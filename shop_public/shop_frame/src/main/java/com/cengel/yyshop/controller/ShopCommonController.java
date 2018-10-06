package com.cengel.yyshop.controller;

import com.cengel.starbucks.model.obj.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/2 - 15:00
 * @Version V1.0
 **/
@Controller
@RequestMapping("common")
public class ShopCommonController {

	@RequestMapping("error")
	public String error(Integer code,String message,ModelMap modelMap){
		modelMap.put("port",code);
		modelMap.put("message",message);
		return "/common/error";
	}

	@RequestMapping("errorJson")
	@ResponseBody
	public Response errorJson(Integer code,String message){
		return Response.error(message).add("port",code);
	}
}
