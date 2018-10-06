package com.cengel.yyshop.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Configuration;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/29 - 9:56
 * @Version V1.0
 **/
@Configuration
@EnableAutoConfiguration
@EnableConfigServer
public class ShopConfigApplication {
	public static void main(String[] args) {
		SpringApplication.run(ShopConfigApplication.class, args);
	}
}

