package com.cengel.yyshop.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 11:39
 * @Version V1.0
 **/
@Slf4j
@Component
public class ShopCommonTimerTask {

	/**
	 * 每1分钟执行一次
	 */
	//	@Scheduled(cron = "0/60 * * * * ? ")
	public void doInMinute() {
	}

	@Scheduled(cron = "0 0/15 1,2 * * ?")
	public void doInNight() {
		//todo 每天夜里12点45到1点45之间，每15分钟 执行一次
		log.warn("===> 夜间执行.......");
	}

}
