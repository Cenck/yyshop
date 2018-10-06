package com.cengel.yyshop.promotion.service.impl;

import com.cengel.hibernate.context.HibernateUtil;
import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.redis.helper.RedisHelper;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.common.server.OrderServerFactory;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.yyshop.promotion.enums.SeckillOrderStateEnum;
import com.cengel.yyshop.promotion.service.ShopSeckillOrderService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CacheMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.sql.Connection;

import static com.cengel.yyshop.constant.ShopRedisKeys.OrderKeys.KEY_SECKILL_ORDER_COUNT;

/**
 * 业务层：秒杀记录表
 */
@Slf4j
@Service
public class ShopSeckillOrderServiceImpl extends BaseServiceImpl<ShopSeckillOrder, Integer> implements ShopSeckillOrderService {
	@Autowired
	private OrderServerFactory serverFactory;
	@Autowired
	private RedisHelper        redisHelper;

	@Override
	public Response doCreateSeckillOrder(ShopSeckill shopSeckill, Double num) {
		long startTime = System.currentTimeMillis();
		log.info("sessionId-2:{},thread:{}", System.identityHashCode(HibernateUtil.currentSession()),Thread.currentThread().getName());

		Assert.notNull(shopSeckill, "秒杀商品不能为空");
		Assert.notNull(shopSeckill.getId(), "秒杀商品不能为空");
		Assert.notNull(shopSeckill.getGoodsId(), "秒杀商品不能为空");

		ShopSeckillOrder seckillOrder = new ShopSeckillOrder();
		double discountPrice = 0.0;
		Integer count = redisHelper.incr(KEY_SECKILL_ORDER_COUNT + shopSeckill.getId());
		if (isLuckyOrder(count)) {
			seckillOrder.setIsLucky(true);
			discountPrice = getSeckillDiscountPrice(shopSeckill.getId());
			seckillOrder.setDiscountPrice(new BigDecimal(discountPrice));
		}
		// todo rpc前多个线程拿到的shopSeckill的库存是同一个，远程调用结束后就出现了并发问题，读到库存的脏数据

		//		ShopGoodsDO goodsDO = serverFactory.shopGoodsServer.getGoodsDetail(shopSeckill.getGoodsId());
		/********************|| 生成订单 ||********************/
		Response response = serverFactory.shopGoodsServer.doCreateGoodsOrder(shopSeckill.getGoodsId(), num, discountPrice, UserHolder.getUser());

		seckillOrder.setSeckillId(shopSeckill.getId());
		seckillOrder.setState(SeckillOrderStateEnum.CREATED.getState());
		seckillOrder.setMemberId(UserHolder.getUser().getId());
		seckillOrder.setOrderId(response.getObj());
		seckillOrder.setMemberName(UserHolder.getUser().getNickName());
		seckillOrder.setCostTime((int) (System.currentTimeMillis() - startTime));
		seckillOrder.setBuyIndex(count);
		this.getBaseDao().insert(seckillOrder);
		BigDecimal buyAmount = new BigDecimal(num);
//		shopSeckill = (ShopSeckill) HibernateUtil.currentSession().createCriteria(ShopSeckill.class).setCacheable(false).add(Restrictions.idEq(shopSeckill.getId())).setLockMode(LockMode.PESSIMISTIC_WRITE).uniqueResult();
		BigDecimal oldStock = shopSeckill.getSeckNum();
		shopSeckill.setSeckNum(oldStock.subtract(buyAmount));
		this.getBaseDao().update(shopSeckill);
		log.info("sessionId-3:{},thread:{}", System.identityHashCode(HibernateUtil.currentSession()),Thread.currentThread().getName());
		log.info("订单生成成功==orderId:{},扣减原库存{}为{},版本号为:{}\n shopSeckill的内存地址：{}", response.getObj().toString(), oldStock, shopSeckill.getSeckNum(), shopSeckill.getVersion(), System.identityHashCode(shopSeckill));

		return Response.success("秒杀成功").addData(seckillOrder);
	}

	//获取该秒杀商品的折扣价
	public Double getSeckillDiscountPrice(Integer seckId) {
		return 100.0;
	}

	public boolean isLuckyOrder(Integer seckCount) {
		return 100 == seckCount;
	}

}
