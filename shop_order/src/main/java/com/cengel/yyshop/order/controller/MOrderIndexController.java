package com.cengel.yyshop.order.controller;

import com.cengel.yyshop.promotion.service.ShopSeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/13 - 18:08
 * @Version V1.0
 **/
@Controller
@RequestMapping("/m/o")
public class MOrderIndexController {

	@Autowired
	private ShopSeckillService shopSeckillService;

	@RequestMapping("index")
	public String hello(ModelMap modelMap){
		modelMap.put("seckill",shopSeckillService.getGoodsVo(1));
		return "/manage/order-index";
	}
}
