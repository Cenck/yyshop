package com.cengel.yyshop.property.service;

import com.cengel.hibernate.service.BaseService;
import com.cengel.yyshop.property.entity.ShopGoodsStock;

/**
 * 业务层：商品库存
 */
public interface ShopGoodsStockService  extends BaseService<ShopGoodsStock, Integer>  {

	/**
	 * 下订单的时候扣减的是冻结库存
	 * 生成订单前从商品页面跳转订单页面，会先冻结库存
	 * @param goodsId
	 * @param deductNum
	 */
	void doDeductFreezeStock(Integer goodsId, Double deductNum);

}
