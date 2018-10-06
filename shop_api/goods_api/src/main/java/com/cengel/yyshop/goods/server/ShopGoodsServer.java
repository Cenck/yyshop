package com.cengel.yyshop.goods.server;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.goods.dao.ShopGoodsDO;

public interface ShopGoodsServer {

	ShopGoodsDO getGoodsDetail(Integer goodsId);

	/***
	 * 功能描述: 扣减商品库存
	 * @author: zhz
	 * @param: $1 商品id $2
	 * @date: 2018/9/22 - 14:03
	 * @return:
	 */
	Response doCreateGoodsOrder(Integer goodsId, Double buyAmount, Double discountPrice,OnlineUser user);

}
