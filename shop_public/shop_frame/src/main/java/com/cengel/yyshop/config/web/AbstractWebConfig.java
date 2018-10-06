package com.cengel.yyshop.config.web;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;

/**
 * @Title: 基于百里香叶的视图解析
 * @Description:
 * @Author zhz
 * @Time 2018/7/15 - 11:11
 * @Version V1.0
 **/
@EnableWebMvc
public abstract class AbstractWebConfig extends WebMvcConfigurationSupport {

	//	百里香叶
	@Bean
	public ITemplateResolver templateResolver() {
		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("classpath:/templates/");
		templateResolver.setTemplateMode("LEGACYHTML5");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false); //允许模板缓存
//		templateResolver.setCacheTTLMs(20 * 1000L); //模板缓存最大存活时间
		templateResolver.setCharacterEncoding("utf-8");
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine(ITemplateResolver TemplateResolver) {
		SpringTemplateEngine springTemplateEngine = new SpringTemplateEngine();
		springTemplateEngine.setTemplateResolver(TemplateResolver);
		return springTemplateEngine;
	}

	@Bean
	public ViewResolver ThymeleafViewResolver(SpringTemplateEngine templateEngine) {
		//todo 百里香叶
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		viewResolver.setCharacterEncoding("utf-8");
		return viewResolver;
	}

}
