package com.cengel.yyshop.central.controller;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.central.facade.MUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 10:03
 * @Version V1.0
 **/
@Controller
@RequestMapping("/m/uc")
public class MUserController {

	@Autowired
	private MUserFacade userFacade;

	@RequestMapping("index")
	public String index() {
		return "/manage/central-index";
	}

	@RequestMapping("refreshAll")
	@ResponseBody
	public Response refreshAll(){
		return userFacade.refreshAll();
	}

}
