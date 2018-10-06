package com.cengel.yyshop.app.security;

import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 9:22
 * @Version V1.0
 **/
//@EnableAuthorizationServer
public class WebAppAuthorizationSecurityConfig extends AuthorizationServerConfigurerAdapter {

	/**
	 * Configure.
	 *
	 * @param clients the clients
	 *
	 * @throws Exception the exception
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory() // 使用in-memory存储
				.withClient("client") // client_id
				.secret("secret") // client_secret
				.authorizedGrantTypes("authorization_code") // 该client允许的授权类型
				.scopes("app"); // 允许的授权范围
	}




}
