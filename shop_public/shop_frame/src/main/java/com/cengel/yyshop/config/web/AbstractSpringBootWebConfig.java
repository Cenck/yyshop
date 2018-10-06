package com.cengel.yyshop.config.web;

import com.cengel.starbucks.context.BeanContext;
import com.cengel.starbucks.model.obj.BaseContext;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/29 - 10:36
 * @Version V1.0
 **/
public abstract class AbstractSpringBootWebConfig {

	@Bean
	public BeanContext BeanContext() {
		return new BeanContext();
	}

	@Bean
	@ConfigurationProperties("pojo.base-context")
	@ConditionalOnMissingBean(BaseContext.class)
	public BaseContext baseContext() {
		return new BaseContext();
	}
}
