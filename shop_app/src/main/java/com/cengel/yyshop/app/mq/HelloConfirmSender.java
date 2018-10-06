package com.cengel.yyshop.app.mq;

import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import static com.cengel.yyshop.constant.ShopMqQueueConstant.APP_MQ_EXCHANGE;
import static com.cengel.yyshop.constant.ShopMqQueueConstant.APP_MQ_QUEUE;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 12:35
 * @Version V1.0
 **/
@Slf4j
@Component
@RabbitListener(queues = APP_MQ_QUEUE)
public class HelloConfirmSender implements RabbitTemplate.ConfirmCallback, RabbitTemplate.ReturnCallback , InitializingBean {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Override
	public void afterPropertiesSet() throws Exception {
		rabbitTemplate.setConfirmCallback(this);
		rabbitTemplate.setReturnCallback(this);
	}

	public void send(String message) {
		CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
		System.out.println("消息id:" + correlationData.getId());
		//用RabbitMQ发送MQTT需将exchange配置为amq.topic
//		this.rabbitTemplate.convertAndSend(APP_MQ_QUEUE,message);
		this.rabbitTemplate.convertAndSend("", APP_MQ_QUEUE, message, correlationData);
	}


	@Override
	public void confirm(CorrelationData correlationData, boolean b, String s) {
		log.warn("消息发送成功");
//		System.out.println(correlationData.getId());
	}

	@Override
	public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {
		log.warn("消息者成功消费了这条消息");
		System.out.println(exchange);
		System.out.println(routingKey);
	}


	@RabbitHandler
	public void processMessage2(String  message, Channel channel,@Headers Map<String,Object> map) {
		System.out.println("2222"+message);
		if (map.get("error")!= null){
			System.out.println("错误的消息");
			try {
				channel.basicNack((Long)map.get(AmqpHeaders.DELIVERY_TAG),false,true);      //否认消息
				return;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			channel.basicAck((Long)map.get(AmqpHeaders.DELIVERY_TAG),false);            //确认消息
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
