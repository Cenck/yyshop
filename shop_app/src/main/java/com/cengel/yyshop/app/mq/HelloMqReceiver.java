package com.cengel.yyshop.app.mq;

import com.cengel.yyshop.mqsource.HelloMqSource;
import com.rabbitmq.client.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;

import java.io.IOException;

import static com.cengel.yyshop.constant.ShopMqQueueConstant.APP_MQ_QUEUE;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/23 - 11:41
 * @Version V1.0
 **/
@Slf4j
@EnableBinding(HelloMqSource.class)
public class HelloMqReceiver {

	@StreamListener(HelloMqSource.HELLO_MQ_CONSUMER)
	public void changeConsume(Message<String> message) {

		String hello = message.getPayload();
		log.warn(hello);

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
		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		// channel.basicQos(1);//使得每个Consumer在同一个时间点最多处理一个Message。在接收到该Consumer的ack前，不会将新的Message分发给它
		Consumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope,AMQP.BasicProperties properties,byte[] body) throws IOException {
				String message = new String(body, "UTF-8");
				System.out.println(" [x] Received '" + message + "'");
				// channel.basicAck(envelope.getDeliveryTag(), false);
			}
		};
		channel.basicConsume(APP_MQ_QUEUE, false, consumer);
	}
}
