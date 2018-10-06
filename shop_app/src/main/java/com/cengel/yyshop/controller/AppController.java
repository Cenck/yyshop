package com.cengel.yyshop.controller;

import com.cengel.starbucks.enums.ResultCodeEnum;
import com.cengel.starbucks.model.obj.BaseContext;
import com.cengel.starbucks.model.obj.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/20 - 17:13
 * @Version V1.0
 **/
@RequestMapping
@Controller
public class AppController {

	@Autowired
	private BaseContext baseContext;

	@RequestMapping
	public String welcome() {
		return "redirect:"+baseContext.getBasePath()+"/swap/index.html";
	}

	@RequestMapping("toLogin")
	@ResponseBody
	public Response toLogin() {
		return Response.code(ResultCodeEnum.USR_NO_LOGIN);
	}

}
