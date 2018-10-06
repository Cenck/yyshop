package com.cengel.yyshop.property.service.impl;

import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.starbucks.util.AssertUtil;
import com.cengel.yyshop.property.entity.ShopGoodsStock;
import com.cengel.yyshop.property.service.ShopGoodsStockService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 业务层：商品库存
 */
@Service
public class ShopGoodsStockServiceImpl extends BaseServiceImpl<ShopGoodsStock, Integer> implements ShopGoodsStockService {
	@Override
	public void doDeductFreezeStock(Integer goodsId, Double deductNum) {
		ShopGoodsStock stock = new ShopGoodsStock();
		stock.setGoodsId(goodsId);
		stock.setDistrictId(UserHolder.getUser().getDistId());
		List<ShopGoodsStock> list = this.find(stock);
		AssertUtil.notNull(list, "商品库存不存在");
		AssertUtil.Assert(list.size() > 1, "商品存在多个库存");
		ShopGoodsStock recordStock = list.get(0);
		if (recordStock.getStockNum() == null) recordStock.setStockNum(BigDecimal.ZERO);
		recordStock.setFreezeNum(recordStock.getFreezeNum().subtract(new BigDecimal(deductNum)));
		this.update(recordStock);
	}
}
