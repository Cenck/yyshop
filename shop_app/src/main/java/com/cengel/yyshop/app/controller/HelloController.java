package com.cengel.yyshop.app.controller;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.app.mq.HelloConfirmSender;
import com.cengel.yyshop.app.mq.HelloMqSender;
import com.cengel.yyshop.app.config.AppServerFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/19 - 21:35
 * @Version V1.0
 **/
@RestController
@RequestMapping("hello")
public class HelloController {

	@Autowired
	private AppServerFactory serverFactory;

	@RequestMapping
	public Response hello() {
		String name = "swap";
		List<Hello> list = new ArrayList<>();
		list.add(new Hello("WebApp", "http://yyshop.com/app"));
		list.add(new Hello("PC商城前台", ""));
		list.add(new Hello("商城管理平台", ""));
		return Response.success()
				.addData(list)
				.add("name", name)
				.add("hello", "你好");
	}


	@Autowired
	private HelloConfirmSender     helloConfirmSender;
	@Autowired
	private HelloMqSender helloMqSender;

	@RequestMapping("mq")
	public Response m1(){
//		helloMqSender.sayHello("你好啊");
		helloConfirmSender.send("消息能确认吗？");
		return Response.success("6666");
	}




	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	private class Hello {
		private String name;
		private String url;
	}

}
