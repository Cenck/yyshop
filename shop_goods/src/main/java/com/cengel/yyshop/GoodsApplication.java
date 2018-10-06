package com.cengel.yyshop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cengel.hibernate.config.SpringBootHibernateConfig;
import com.cengel.redis.config.SpringBootRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Title: 商品
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 19:34
 * @Version V1.0
 **/
@SpringBootApplication
@Configuration
@EnableDubbo
@Import({ SpringBootHibernateConfig.class, SpringBootRedisConfig.class })
public class GoodsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoodsApplication.class);
	}
}
