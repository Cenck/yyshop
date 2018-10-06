package com.cengel.yyshop.test;

import com.cengel.yyshop.test.facade.MTestUserMenuFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/4 - 19:03
 * @Version V1.0
 **/
@RestController
@RequestMapping("/test")
public class MTestController {

	@Autowired
	private MTestUserMenuFacade userMenuFacade;

	@RequestMapping("thread")
	public String thread(){
		return "hello,事务";
	}

	@RequestMapping("trans")
	public String trans(){
		userMenuFacade.doTestTrans();
		return "hello,事务";
	}



}
