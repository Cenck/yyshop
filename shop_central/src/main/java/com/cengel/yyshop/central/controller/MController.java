package com.cengel.yyshop.central.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 15:22
 * @Version V1.0
 **/
@Controller
@RequestMapping()
public class MController {

	@RequestMapping("hello")
	public String hello(){
		return "/hello";
	}
}
