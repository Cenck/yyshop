package com.cengel.yyshop.app.security;

import com.cengel.yyshop.app.filter.AppAccessFilter;
import com.cengel.yyshop.facade.AppMemberLoginFacade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 9:53
 * @Version V1.0
 **/
@Slf4j
@Configuration
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
				.antMatchers("/toLogin",
						"/static/**",
						"/favor.ico",
						"/**/.css",
						"/**/*.js",

						"/**/stomp/**",

						//站内游客浏览页
						"/home/index",

						"/**/test/**");
	}

	@Autowired
	private AppAccessFilter appAccessFilter;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterBefore(appAccessFilter, AbstractPreAuthenticatedProcessingFilter.class);
		//		http.addFilterBefore(appAccessFilter, UsernamePasswordAuthenticationFilter.class);
		http.authorizeRequests()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin()
				.loginPage("/toLogin")
				.loginProcessingUrl("/authentication")
				.permitAll()
				.and()
				.rememberMe()
				.tokenValiditySeconds(7 * 24 * 60 * 60)
				.key("token_swap");
		http.csrf()
				.disable();
	}

	@Autowired
	private AppMemberLoginFacade appMemberLoginFacade;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appMemberLoginFacade);
	}
}
