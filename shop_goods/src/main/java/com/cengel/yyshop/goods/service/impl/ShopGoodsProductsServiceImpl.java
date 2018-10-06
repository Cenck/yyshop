package com.cengel.yyshop.goods.service.impl;

import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.starbucks.util.AssertUtil;
import com.cengel.yyshop.goods.entity.ShopGoodsProducts;
import com.cengel.yyshop.goods.service.ShopGoodsProductsService;
import org.springframework.stereotype.Service;


/**
 * 业务层：
 */
@Service
public class ShopGoodsProductsServiceImpl  extends BaseServiceImpl<ShopGoodsProducts, Integer> implements ShopGoodsProductsService {
	@Override
	public void saveOrUpdate(ShopGoodsProducts shopGoodsProducts) {
		AssertUtil.notNull(shopGoodsProducts.getProductsName(),"产品名称不能为空");
		super.saveOrUpdate(shopGoodsProducts);
	}

}
