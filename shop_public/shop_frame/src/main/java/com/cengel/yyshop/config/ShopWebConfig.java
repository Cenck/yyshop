package com.cengel.yyshop.config;

import com.cengel.mq.aspect.MqPersistAspect;
import com.cengel.mq.biz.MqPersistBiz;
import com.cengel.mq.enums.MqPersistStateEnum;
import com.cengel.yyshop.config.web.AbstractSpringBootWebConfig;
import lombok.extern.slf4j.Slf4j;
import org.sitemesh.webapp.CgSiteMeshFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.Filter;
import java.io.Serializable;

import static org.sitemesh.config.ConfigurableSiteMeshFilter.CONFIG_FILE_PARAM;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 18:30
 * @Version V1.0
 **/
@Slf4j
@Configuration
@EnableWebMvc
@ComponentScan({ "com.cengel.yyshop" })
public class ShopWebConfig extends AbstractSpringBootWebConfig {

	@Bean
	public FilterRegistrationBean siteMeshFilter() {
		FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
		bean.setFilter(new CgSiteMeshFilter());
		bean.addInitParameter(CONFIG_FILE_PARAM, "classpath:/conf/sitemesh-config.xml");
		bean.addUrlPatterns("/m/*");// 拦截路径 - 由于在项目内mgr为最外层，不需要+contextPath
		bean.setName("sitemeshFilter");
		return bean;
	}

	/********************|| mq消息持久化 ||********************/
	@Bean
	public MqPersistBiz MqPersistBiz() {
		return new MqPersistBiz() {
			@Override
			public void save(Serializable msgMqe) {
				log.info("不持久化消息");
			}

			@Override
			public void updateState(MqPersistStateEnum mqPersistStateEnum) {
				log.info("update=不持久化消息");
			}
		};
	}

	@Bean
	public MqPersistAspect mqPersistAspect() {
		return new MqPersistAspect(MqPersistBiz());
	}

}
