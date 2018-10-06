package com.cengel.yyshop.promotion.biz.impl;

import com.cengel.hibernate.context.HibernateUtil;
import com.cengel.hibernate.dao.BaseDao;
import com.cengel.starbucks.exception.BusinessException;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.goods.entity.ShopGoods;
import com.cengel.yyshop.goods.server.ShopGoodsServer;
import com.cengel.yyshop.mqe.CreateGoodsOrderMqe;
import com.cengel.yyshop.promotion.biz.ShopSeckillBuilderBiz;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.yyshop.promotion.enums.SeckillOrderStateEnum;
import com.cengel.yyshop.promotion.service.ShopSeckillOrderService;
import com.cengel.yyshop.property.entity.ShopGoodsStock;
import com.cengel.yyshop.sender.ShopGoodsSender;
import com.cengel.yyshop.sender.ShopSeckSender;
import com.cengel.yyshop.service.GoodsCacheService;
import com.cengel.yyshop.service.SeckillCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 19:48
 * @Version V1.0
 **/
@Slf4j
@Service
public class ShopSeckillBuilderBizImpl extends AbstractShopSeckillBuilder implements ShopSeckillBuilderBiz {

	@Autowired
	private BaseDao                 baseDao;
	@Autowired
	private GoodsCacheService       goodsCacheService;
	@Autowired
	private SeckillCacheService     seckillCacheService;
	@Autowired
	private ShopSeckillOrderService seckillOrderService;
	@Autowired
	private ShopGoodsServer         goodsServer;
	@Autowired
	private ShopSeckSender          shopSeckSender;
	@Autowired
	private ShopGoodsSender         shopGoodsSender;

	@Override
	void handleStock(ShopSeckill seck, long totalNum) {
		/********************|| 冻结商品库存 ||********************/
		ShopGoods shopGoods = baseDao.get(seck.getGoodsId(), ShopGoods.class);
		//取一个可用库存，并更新
		ShopGoodsStock temp = new ShopGoodsStock();
		temp.setDeleted(false);
		temp.setGoodsId(shopGoods.getId());
		temp.setDistrictId(UserHolder.getUser().getDistId());
		List<ShopGoodsStock> stocks = baseDao.find(temp);
		BigDecimal amount = new BigDecimal(totalNum);
		if (stocks != null && stocks.size() > 0) {
			ShopGoodsStock stock = stocks.get(0);
			if (stock.getStockNum() == null) stock.setStockNum(BigDecimal.ZERO);
			if (stock.getFreezeNum() == null) stock.setFreezeNum(BigDecimal.ZERO);
			if (stock.getTotalNum() == null) stock.setTotalNum(BigDecimal.ZERO);
			if (stock.getStockNum().compareTo(amount) == 1) {
				stock.setFreezeNum(stock.getFreezeNum().add(amount));
				stock.setStockNum(stock.getStockNum().subtract(amount));
				stock.setTotalNum(stock.getTotalNum().subtract(amount));
				baseDao.update(stock);
			}
		} else throw new IllegalStateException(seck.getSkName() + "库存不足");
		if (shopGoods.getTotalStockNum() == null) shopGoods.setTotalStockNum(BigDecimal.ZERO);
		shopGoods.setTotalStockNum(shopGoods.getTotalSaleNum().add(amount));
		goodsCacheService.set(shopGoods.getId(), shopGoods);
		/********************|| 增加seck库存 ||********************/
		if (seck.getSeckNum() == null) seck.setSeckNum(BigDecimal.ZERO);
		seck.setSeckNum(seck.getSeckNum().add(amount));
	}

	@Override
	void renderSeck(ShopSeckill seck, Date begDate, Date endDate) {
		seck.setStartTime(begDate);
		seck.setEndTime(endDate);
		shopSeckillService.update(seck);
	}

	@Override
	void sendMqMsgAsync(ShopSeckill shopSeckill) {
		//发送
		shopSeckSender.sendPrepare(shopSeckill.getId(), shopSeckill.getStartTime(), shopSeckill.getEndTime());
	}

	/********************|| 开始下订单  ||********************/

	@Override
	ShopSeckill doGetAndCheck(Integer id, Double buyNum) {
		ShopSeckill ret;
		if (id == null || (ret = (ShopSeckill) shopSeckillService.get(id)) == null) throw new BusinessException("秒杀订单不存在:" + id);
		Assert.notNull(ret.getGoodsId(), "秒杀商品不能为空");
		Date today = new Date();
		if (today.before(ret.getStartTime())) {
			throw new BusinessException("秒杀还未开始:" + id);
		}
		if (today.after(ret.getEndTime())) {
			throw new BusinessException("很遗憾，秒杀已结束。看看其他商品吧");
		}
		BigDecimal buyAmount = new BigDecimal(buyNum);
		if (ret.getSeckNum().compareTo(buyAmount) < 1) {
			throw new BusinessException("秒杀商品：" + ret.getSkName() + "库存不足");
		}
		/********************|| 检查用户是否为二次购买 ||********************/
		//		if (1 != UserHolder.getId()){
		//			ShopSeckillOrder order = new ShopSeckillOrder();
		//			order.setSeckillId(id);
		//			order.setMemberId(UserHolder.getId());
		//			List list = shopSeckillService.getBaseDao().find(order);
		//			if (list!=null && list.size()>0) throw new BusinessException("您已经买过了");
		//		}
		return ret;
	}

	@Override
	ShopSeckillOrder createSeckOrder(ShopSeckill shopSeckill, Double num) {
		log.info("sessionId-2:{},thread:{}", System.identityHashCode(HibernateUtil.currentSession()), Thread.currentThread().getName());
		long startTime = System.currentTimeMillis();
		ShopSeckillOrder seckillOrder = new ShopSeckillOrder();
		double discountPrice = 0.0;
		Integer count = seckillCacheService.incrSeckCount(shopSeckill.getId());
		if (seckillOrderService.isLuckyOrder(count)) {
			seckillOrder.setIsLucky(true);
			discountPrice = seckillOrderService.getSeckillDiscountPrice(shopSeckill.getId());
			seckillOrder.setDiscountPrice(new BigDecimal(discountPrice));
		}

		if (true) {
			seckillOrder.setOrderId(0);
			seckillOrder.setState(SeckillOrderStateEnum.QUEUED.getState());
		} else {
			//todo rpc直接远程调用 ，超耗费性能

			// todo rpc前多个线程拿到的shopSeckill的库存是同一个，远程调用结束后就出现了并发问题，读到库存的脏数据
			//		ShopGoodsDO goodsDO = serverFactory.shopGoodsServer.getGoodsDetail(shopSeckill.getGoodsId());
			/********************|| 生成订单 ||********************/
			Response response = goodsServer.doCreateGoodsOrder(shopSeckill.getGoodsId(), num, discountPrice, UserHolder.getUser());
			seckillOrder.setOrderId(response.getObj());
			seckillOrder.setState(SeckillOrderStateEnum.CREATED.getState());
		}

		seckillOrder.setSeckillId(shopSeckill.getId());
		seckillOrder.setMemberId(UserHolder.getUser().getId());
		seckillOrder.setMemberName(UserHolder.getUser().getNickName());
		seckillOrder.setCostTime((int) (System.currentTimeMillis() - startTime));
		seckillOrder.setBuyIndex(count);
		baseDao.insert(seckillOrder);
		BigDecimal buyAmount = new BigDecimal(num);
		BigDecimal oldStock = shopSeckill.getSeckNum();
		shopSeckill.setSeckNum(oldStock.subtract(buyAmount));
		baseDao.update(shopSeckill);

		//todo 思路二 异步处理商品和订单,思路一：所有请求入队，持久化mq消息队列，秒杀高峰结束后，逐一下单
		shopGoodsSender.sendCreateGoodsTaskAsync(new CreateGoodsOrderMqe(shopSeckill.getId(),buyAmount,new BigDecimal(discountPrice),UserHolder.getId(),seckillOrder.getId()));

		log.info("订单生成成功==orderId:{},扣减原库存{}为{},版本号为:{}\n shopSeckill的内存地址：{}", seckillOrder.getOrderId(), oldStock, shopSeckill.getSeckNum(), shopSeckill.getVersion(), System.identityHashCode(shopSeckill));
		return seckillOrder;
	}

}
