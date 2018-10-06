package com.cengel.yyshop;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.cengel.hibernate.config.SpringBootHibernateConfig;
import com.cengel.redis.config.SpringBootRedisConfig;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/19 - 19:51
 * @Version V1.0
 **/
@SpringBootApplication(scanBasePackages ="com.cengel.yyshop")
@EnableDubbo
@Import({SpringBootHibernateConfig.class, SpringBootRedisConfig.class })
@EnableScheduling
public class ProviderApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ProviderApplication.class)
				.web(WebApplicationType.NONE)
				.run(args);
	}
}
