package com.cengel.yyshop;

import com.cengel.hibernate.config.SpringBootHibernateConfig;
import com.cengel.redis.config.SpringBootRedisConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/29 - 10:44
 * @Version V1.0
 **/
@SpringBootApplication
@Configuration
@Import({ SpringBootHibernateConfig.class, SpringBootRedisConfig.class })
public class CentralApplication {
	public static void main(String[] args) {
		SpringApplication.run(CentralApplication.class, args);
	}
}
