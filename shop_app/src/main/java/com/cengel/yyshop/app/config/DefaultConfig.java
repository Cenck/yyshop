package com.cengel.yyshop.app.config;

import com.cengel.starbucks.model.obj.BaseContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 10:26
 * @Version V1.0
 **/
@Configuration
@Slf4j
public class DefaultConfig {

	/********************|| web-common ||********************/
	@Bean
	@ConditionalOnMissingBean(BaseContext.class)
	@ConfigurationProperties("pojo.base-context")
	public BaseContext baseContext() {
		return new BaseContext();
	}

	/********************|| Security ||********************/
	@Bean
	@ConditionalOnMissingBean(PasswordEncoder.class)
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
