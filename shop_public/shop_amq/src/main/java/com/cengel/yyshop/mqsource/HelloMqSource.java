package com.cengel.yyshop.mqsource;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

//消息通道
public interface HelloMqSource extends Processor {
	String HELLO_MQ_PROVIDER = "helloOut";
	String HELLO_MQ_CONSUMER = "helloIn";

	@Input(HELLO_MQ_CONSUMER)
    SubscribableChannel HelloInChannel();
    @Output(HELLO_MQ_PROVIDER)
    MessageChannel helloOutChannel();

}
