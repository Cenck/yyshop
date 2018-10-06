package com.cengel.yyshop.promotion.server;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.promotion.biz.ShopSeckillBuilderBiz;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.service.ShopSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 19:48
 * @Version V1.0
 **/
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopSeckillServerImpl implements ShopSeckillServer {

	@Autowired
	private ShopSeckillService    shopSeckillService;
	@Autowired
	private ShopSeckillBuilderBiz shopSeckillBuilderBiz;

	@Override
	public ShopSeckill getOne() {
		return shopSeckillService.get(1);
	}

	@Override
	public Response doPrepare(Integer seckId, long totalNum, Date begDate, Date endDate) {
		return shopSeckillBuilderBiz.doPrepare(seckId, totalNum, begDate, endDate);
	}

	@Override
	public Response doCreateOrder(Integer seckId, Double buyNum, OnlineUser user) {
		return shopSeckillBuilderBiz.doCreateOrder(seckId, buyNum);
	}

}
