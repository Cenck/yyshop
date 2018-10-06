package com.cengel.yyshop.common.server;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cengel.yyshop.goods.server.ShopGoodsServer;
import com.cengel.yyshop.member.server.ShopMemberServer;
import com.cengel.yyshop.server.AbstractServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.DubboProtocolConstant.GOODS_PROTOCOL_ADDR;
import static com.cengel.yyshop.constant.DubboProtocolConstant.PROVIDER_PROTOCOL_ADDR;

@Service
public class OrderServerFactory extends AbstractServerFactory{

	@Reference(url = PROVIDER_PROTOCOL_ADDR)
	public ShopMemberServer memberServer;

	@Reference(url = GOODS_PROTOCOL_ADDR, check = false)
	public ShopGoodsServer shopGoodsServer;

	@Bean("ShopMemberServer")
	public ShopMemberServer ShopMemberServer(){
		return memberServer;
	}
	@Bean("ShopGoodsServer")
	ShopGoodsServer ShopGoodsServer(){
		return shopGoodsServer;
	}

}
