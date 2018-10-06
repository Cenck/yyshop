package com.cengel.yyshop.promotion.service;

import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.hibernate.service.BaseService;
import com.cengel.yyshop.promotion.vo.ShopSeckillGoodsVo;

/**
 * 业务层：商品秒杀
 */
public interface ShopSeckillService  extends BaseService<ShopSeckill, Integer>  {
	ShopSeckillGoodsVo getGoodsVo(int  id);

	ShopSeckill doCheckAndGet(Integer id, Double buyNum);
}
