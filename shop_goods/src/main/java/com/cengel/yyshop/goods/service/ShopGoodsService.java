package com.cengel.yyshop.goods.service;

import com.cengel.hibernate.service.BaseService;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.form.ShopGoodsForm;
import com.cengel.yyshop.form.ShopOrderAddressForm;
import com.cengel.yyshop.goods.dto.ShopGoodsInfoDto;
import com.cengel.yyshop.goods.entity.ShopGoods;

import java.util.List;

public interface ShopGoodsService extends BaseService<ShopGoods,Integer> {


	List<ShopGoods> listBanner(int len);

	ShopGoodsInfoDto getDto(Integer id);

	Response doCreateOrder(ShopGoodsForm goodsForm, ShopOrderAddressForm addressForm);


}
