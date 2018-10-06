package com.cengel.yyshop.promotion.service;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.hibernate.service.BaseService;

/**
 * 业务层：秒杀记录表
 */
public interface ShopSeckillOrderService  extends BaseService<ShopSeckillOrder, Integer>  {

	Response doCreateSeckillOrder(ShopSeckill shopSeckill,Double num);

	Double getSeckillDiscountPrice(Integer seckId);
	boolean isLuckyOrder(Integer seckCount);
}
