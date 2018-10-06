package com.cengel.yyshop.test;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.util.DateUtil;
import com.cengel.yyshop.promotion.biz.ShopSeckillBuilderBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 19:41
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class OrderTestController {

	@Autowired
	private ShopSeckillBuilderBiz builderServer;

	@RequestMapping
	public Response index(){
		return builderServer.doPrepare(1,10,new Date(), DateUtil.tomorrow());
	}
}
