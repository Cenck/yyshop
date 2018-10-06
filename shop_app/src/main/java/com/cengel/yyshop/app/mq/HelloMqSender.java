package com.cengel.yyshop.app.mq;

import com.cengel.yyshop.mqsource.HelloMqSource;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import static com.cengel.yyshop.constant.ShopMqQueueConstant.APP_MQ_QUEUE;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 11:42
 * @Version V1.0
 **/
@EnableBinding(HelloMqSource.class)
public class HelloMqSender {

	@Autowired
	private HelloMqSource helloMqSource;

	public void sayHello(String text){
		helloMqSource.helloOutChannel().send(MessageBuilder.withPayload(text).build());
	}

	public static void main(String[] argv) throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("mq.yyshop.com");
		factory.setPort(5672);
		factory.setUsername("admin");
		factory.setPassword("zc1992");
		Connection connection = factory.newConnection();
		Channel channel = connection.createChannel();
		channel.queueDeclare(APP_MQ_QUEUE, false, false, false, null);
		String message = "Hello World!kkkkkkkkkkkkkk";
		channel.basicPublish("", APP_MQ_QUEUE, null, message.getBytes("UTF-8"));
		System.out.println(" [x] Sent '" + message + "'");
		channel.close();
		connection.close();
	}
}
