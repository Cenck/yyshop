package com.cengel.yyshop.mqsource;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/28 - 13:41
 * @Version V1.0
 **/
public interface ShopSeckillSource {

	/********************|| 秒杀前处理 ||********************/
	String SECK_PREPRARE_IN = "seckPrepareIn";
	String SECK_PREPARE_OUT = "seckPrepareOut";
	@Input(SECK_PREPRARE_IN)
	SubscribableChannel seckPrepareIn();
	@Output(SECK_PREPARE_OUT)
	MessageChannel seckPrepareOut();


}
