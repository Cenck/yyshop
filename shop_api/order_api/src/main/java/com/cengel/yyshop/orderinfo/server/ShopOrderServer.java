package com.cengel.yyshop.orderinfo.server;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.form.ShopGoodsForm;
import com.cengel.yyshop.form.ShopOrderAddressForm;

public interface ShopOrderServer {

	/**
	 * 生成商品订单，保存商品快照等
	 * @return
	 */
	Response doCreateGoodsOrder(ShopGoodsForm shopGoodsForm, ShopOrderAddressForm addrForm, OnlineUser user);

}
