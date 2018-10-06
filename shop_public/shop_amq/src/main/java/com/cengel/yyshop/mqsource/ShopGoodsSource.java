package com.cengel.yyshop.mqsource;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface ShopGoodsSource {

	/********************|| 异步通知商品中心处理商品库存等 ||********************/
	String CREATE_GOODS_TASK_ASYNC_IN  = "sendCreateGoodsTaskAsyncIn";
	String CREATE_GOODS_TASK_ASYNC_OUT = "sendCreateGoodsTaskAsyncOut";
	@Input(CREATE_GOODS_TASK_ASYNC_IN)
	SubscribableChannel sendCreateGoodsTaskAsyncIn();
	@Output(CREATE_GOODS_TASK_ASYNC_OUT)
	MessageChannel sendCreateGoodsTaskAsyncOut();

}
