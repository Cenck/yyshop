package com.cengel.yyshop.config;

import com.cengel.yyshop.config.thread.VisiableThreadPoolTaskExecutor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/4 - 19:25
 * @Version V1.0
 **/
@EnableAsync
@Configuration
public class ThreadConfig {

	@Bean
	public Executor asyncServiceExecutor() {
		//todo 配置线程池
		ThreadPoolTaskExecutor executor = new VisiableThreadPoolTaskExecutor();
		//配置核心线程数
		executor.setCorePoolSize(5);
		//配置最大线程数
		executor.setMaxPoolSize(5);
		//配置队列大小
		executor.setQueueCapacity(99999);
		//配置线程池中的线程的名称前缀
		executor.setThreadNamePrefix("async-service-");

		// rejection-policy：当pool已经达到max size的时候，如何处理新任务
		// CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		//执行初始化
		executor.initialize();
		return executor;
	}

}
