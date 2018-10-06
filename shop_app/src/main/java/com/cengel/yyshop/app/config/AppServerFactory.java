package com.cengel.yyshop.app.config;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cengel.yyshop.goods.server.AppGoodsServer;
import com.cengel.yyshop.goods.server.ShopGoodsServer;
import com.cengel.yyshop.member.server.ShopMemberServer;
import com.cengel.yyshop.promotion.server.ShopSeckillServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.DubboProtocolConstant.*;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/20 - 10:02
 * @Version V1.0
 **/
@Service
@Configuration
public class AppServerFactory {

	@Reference(url = GOODS_PROTOCOL_ADDR)
	public AppGoodsServer  appGoodsServer;
	@Reference(url = GOODS_PROTOCOL_ADDR)
	public ShopGoodsServer goodsServer;

	/********************|| provider ||********************/
	@Reference(url = PROVIDER_PROTOCOL_ADDR)
	public ShopMemberServer memberServer;

	/********************|| order ||********************/
	@Reference(url = ORDER_PROTOCOL_ADDR)
	public ShopSeckillServer seckillServer;

	@Bean
	public AppGoodsServer AppGoodsServer() {
		return appGoodsServer;
	}

	@Bean
	public ShopGoodsServer ShopGoodsServer() {
		return goodsServer;
	}

	@Bean
	public ShopMemberServer ShopMemberServer() {
		return memberServer;
	}

	@Bean
	public ShopSeckillServer ShopSeckillServer() {
		return seckillServer;
	}
}
