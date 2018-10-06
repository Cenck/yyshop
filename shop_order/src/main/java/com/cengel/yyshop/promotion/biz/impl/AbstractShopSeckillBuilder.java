package com.cengel.yyshop.promotion.biz.impl;

import com.cengel.hibernate.context.HibernateUtil;
import com.cengel.starbucks.exception.BusinessException;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.promotion.biz.ShopSeckillBuilderBiz;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.yyshop.promotion.service.ShopSeckillService;
import com.cengel.yyshop.service.UserCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 19:15
 * @Version V1.0
 **/
@Slf4j
public abstract class AbstractShopSeckillBuilder implements ShopSeckillBuilderBiz {

	@Autowired
	protected ShopSeckillService shopSeckillService;
	@Autowired
	private   UserCacheService   userCacheService;

	/********************|| 创建预处理 ||********************/
	//处理库存
	abstract void handleStock(ShopSeckill seck, long totalNum);

	//修改保存seck
	abstract void renderSeck(ShopSeckill seck, Date begDate, Date endDate);

	//异步 mq定时处理，在秒杀开始的前1分钟，保存所有需要的缓存
	abstract void sendMqMsgAsync(ShopSeckill shopSeckill);

	@Override
	public Response doPrepare(Integer seckId, long totalNum, Date begDate, Date endDate) {
		UserHolder.setUser(userCacheService.getDemoManager());
		if (totalNum < 1) throw new BusinessException("预置秒杀商品数量不能为空");
		ShopSeckill shopSeckill = shopSeckillService.get(seckId);
		this.handleStock(shopSeckill, totalNum);
		this.renderSeck(shopSeckill, begDate, endDate);
		this.sendMqMsgAsync(shopSeckill);
		return Response.success("秒杀商品" + shopSeckill.getSkName() + "已重置");
	}

	/********************|| 下单 ||********************/
	// 取并检查
	abstract ShopSeckill doGetAndCheck(Integer id, Double buyNum);

	//创建秒杀订单,
	abstract ShopSeckillOrder createSeckOrder(ShopSeckill shopSeckill, Double buyNum);


	@Override
	public Response doCreateOrder(Integer seckId, Double buyNum) {
		log.info("sessionId-1:{},thread:{}", System.identityHashCode(HibernateUtil.currentSession()), Thread.currentThread().getName());
		ShopSeckill shopSeckill = this.doGetAndCheck(seckId, buyNum);
		ShopSeckillOrder order = this.createSeckOrder(shopSeckill, buyNum);
		return Response.success("秒杀请求成功").addData(order);
	}

	@Override
	public Response doFinish(Integer seckId) {
		return null;
	}

}
