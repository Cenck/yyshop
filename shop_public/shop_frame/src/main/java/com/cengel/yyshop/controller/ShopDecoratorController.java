package com.cengel.yyshop.controller;

import com.cengel.starbucks.annotation.Description;
import com.cengel.yyshop.facade.DecoratorMgrFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.sitemesh.webapp.constant.SitemeshKeys.TARGET_URI;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 10:32
 * @Version V1.0
 **/
@Controller
@RequestMapping("decorator")
public class ShopDecoratorController {

	@Autowired
	private DecoratorMgrFacade mgrFacade;

	@RequestMapping("mgr")
	@Description("管理平台装饰器")
	public String mgr(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response){
		String uri = (String) request.getServletContext().getAttribute(TARGET_URI);
		modelMap.put("uri",uri);
		mgrFacade.buildDecorator(modelMap);
		return "/decorator/mgr-base";
	}


}
