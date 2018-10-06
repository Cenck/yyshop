package com.cengel.yyshop.promotion.server;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.promotion.entity.ShopSeckill;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 19:27
 * @Version V1.0
 **/
public interface ShopSeckillServer {

	ShopSeckill getOne();

	/***
	 * 功能描述: 创建一个秒杀商品
	 * @author: zhz
	 * @param:
	 * @date: 2018/9/28 - 15:39
	 * @return:
	 */
	Response doPrepare(Integer seckId,long totalNum, Date begDate,Date endDate);
	/**
	 * 创建秒杀订单
	 * @param seckId
	 * @param buyNum
	 * @return
	 */
	Response doCreateOrder(Integer seckId, Double buyNum, OnlineUser user);





}
