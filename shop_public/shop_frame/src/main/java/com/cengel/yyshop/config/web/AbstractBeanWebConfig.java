package com.cengel.yyshop.config.web;

import com.cengel.starbucks.context.BeanContext;
import com.cengel.starbucks.core.io.ClassPathResourceResolver;
import com.cengel.starbucks.io.YamlReader;
import com.cengel.starbucks.model.obj.BaseContext;
import org.springframework.context.annotation.Bean;

/**
 * @Title: 各种自定义bean
 * @Description:
 * @Author zhz
 * @Time 2018/8/7 - 20:52
 * @Version V1.0
 **/
public abstract class AbstractBeanWebConfig extends AbstractWebConfig {

	@Bean
	public BeanContext BeanContext() {
		return new BeanContext();
	}

	@Bean
	public BaseContext baseContext() {
		BaseContext baseContext = new BaseContext();
		new YamlReader(ClassPathResourceResolver.getClassPathFile("properties.yml")).readAndFill("webmvc.baseContext", baseContext);
		return baseContext;
	}
}
