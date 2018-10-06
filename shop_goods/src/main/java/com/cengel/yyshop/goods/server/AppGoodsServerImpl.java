package com.cengel.yyshop.goods.server;

import com.alibaba.dubbo.config.annotation.Service;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.goods.service.ShopGoodsService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 12:18
 * @Version V1.0
 **/
@Service
@org.springframework.stereotype.Service
public class AppGoodsServerImpl implements AppGoodsServer {
	@Autowired
	private ShopGoodsService shopGoodsService;

	@Override
	public Response home() {
		return Response.success("成功").add("bannerList", shopGoodsService.listBanner(HOME_BANNER_LEN));
	}
}
