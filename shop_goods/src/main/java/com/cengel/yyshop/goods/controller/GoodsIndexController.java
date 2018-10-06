package com.cengel.yyshop.goods.controller;

import com.cengel.yyshop.goods.facade.GoodsIndexFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 20:15
 * @Version V1.0
 **/
@RequestMapping("/m/g/")
@Controller
public class GoodsIndexController {

	@Resource
	private GoodsIndexFacade  goodsIndexFacade;
	@Resource
	private RedisCacheManager redisCacheManager;

	@RequestMapping("hello")
	public String hello(ModelMap modelMap) {
		modelMap.put("goods",goodsIndexFacade.getHelloGoods());
		return "manage/goods-hello";
	}

	@RequestMapping("index")
	public String index() {
		return "/manage/goods-index";
	}

}
