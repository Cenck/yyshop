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
 * @Time 2018/9/20 - 18:15
 * @Version V1.0
 **/
@RestController
@RequestMapping("home")
public class AppHomeController {

	@Autowired
	private AppServerFactory serverFactory;


	@RequestMapping("index")
	public Response index(){
		return serverFactory.appGoodsServer.home();
	}


}
