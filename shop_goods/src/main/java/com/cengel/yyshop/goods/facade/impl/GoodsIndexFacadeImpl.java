package com.cengel.yyshop.goods.facade.impl;

import com.cengel.yyshop.goods.entity.ShopGoods;
import com.cengel.yyshop.goods.facade.GoodsIndexFacade;
import com.cengel.yyshop.goods.service.ShopGoodsService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Title: \
 * @Description:
 * @Author zhz
 * @Time 2018/8/3 - 17:27
 * @Version V1.0
 **/
@Service
public class GoodsIndexFacadeImpl implements GoodsIndexFacade {

	@Resource
	private ShopGoodsService shopGoodsService;

	@Override
	@Cacheable(value = "randomGoods", key = "'hellogoods'")
	public ShopGoods getHelloGoods() {
		return shopGoodsService.listBanner(1).get(0);
	}

}
