package com.cengel.yyshop.common.server;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cengel.yyshop.member.server.ShopMemberServer;
import com.cengel.yyshop.orderinfo.server.ShopOrderServer;
import com.cengel.yyshop.server.AbstractServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.DubboProtocolConstant.ORDER_PROTOCOL_ADDR;
import static com.cengel.yyshop.constant.DubboProtocolConstant.PROVIDER_PROTOCOL_ADDR;

@Service
public class GoodsServerFactory extends AbstractServerFactory {

	@Reference(url = ORDER_PROTOCOL_ADDR, check = false)
	public ShopOrderServer shopOrderServer;

	@Reference(url = PROVIDER_PROTOCOL_ADDR)
	public ShopMemberServer shopMemberServer;

	@Bean
	public ShopMemberServer ShopMemberServer() {return shopMemberServer;}

}
