package com.cengel.yyshop.sender;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.mqsource.ShopSeckillSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 20:24
 * @Version V1.0
 **/
@Slf4j
@EnableBinding(ShopSeckillSource.class)
public class ShopSeckSender {

	@Autowired
	private ShopSeckillSource shopSeckillSource;

	/**
	 * 秒杀开始前 缓存所有
	 */
	public void sendPrepare(Integer seckId, Date startTime, Date endTime) {
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				log.info("ShopSeckillSource: timer执行了秒杀前mq消息发送任务");
				shopSeckillSource.seckPrepareOut().send(MessageBuilder.withPayload(seckId).build());
			}
		};
		Timer timer = new Timer();
		//在秒杀前一分钟 执行任务
		timer.schedule(timerTask, new Date(startTime.getTime() - 60000));
	}


}
