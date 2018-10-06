package com.cengel.yyshop.controller;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.app.config.AppServerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 18:38
 * @Version V1.0
 **/
@RestController()
@RequestMapping("/test")
public class AppTestController {

	@RequestMapping
	public String  hello(){
		return "hello app";
	}

	@Autowired
	private AppServerFactory serverFactory;
	@RequestMapping("seckill")
	public Response seckill(Integer seckId, Double num) {
		if (num == null || num == 0.0) num = 1.0;
		if (seckId == null || seckId < 1) seckId = 1;
		return serverFactory.seckillServer.doCreateOrder(seckId, num, UserHolder.getUser());
	}

}
