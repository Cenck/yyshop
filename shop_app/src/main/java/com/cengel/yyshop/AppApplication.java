package com.cengel.yyshop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cengel.redis.config.SpringBootRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/16 - 10:03
 * @Version V1.0
 **/
@SpringBootApplication
@EnableDubbo
@Import(SpringBootRedisConfig.class)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
