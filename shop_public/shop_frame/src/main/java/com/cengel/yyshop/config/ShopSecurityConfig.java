package com.cengel.yyshop.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/5 - 18:31
 * @Version V1.0
 **/
@Configuration
@EnableWebSecurity
public class ShopSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		//todo 配置spring security的filter链
		web.ignoring().antMatchers("/static/**","/**/*.ico","/**/stomp/**");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		if (true) {
			http.authorizeRequests().anyRequest()
				.permitAll()
//				.authenticated().and().formLogin()//所有请求需要登录认证
				//.loginPage("/acc/login") //自定义login页面
				.and().authorizeRequests().antMatchers("/acc/login","/api/**").permitAll() //login免过滤
				.and().rememberMe().tokenValiditySeconds(3 * 24 * 60 * 60).key("token__cglab") //登录toKen有效期3天
				.and()
//				.csrf().disable()
				.headers().frameOptions().disable(); //不过滤Frame(使网页可以嵌套frame)
			return;
		}
		//todo 配置如何通过拦截器保护请求
		http.authorizeRequests()
			.anyRequest().authenticated() //任何请求 需要认证
			.and().formLogin()
			//			.loginPage("/myLogin")//自定义登录页面
			.and().logout().logoutSuccessUrl("/hello")
			//			.logoutUrl("/myLoginOut")//自定义退出登录连接
			.and().httpBasic().realmName("spittr")
			.and().rememberMe().tokenValiditySeconds(3*5).key("spittrKey")//记住登录密码，token有效期，token的key
			.and().headers().frameOptions().disable() //不过滤Frame(使网页可以嵌套frame)
			.and().requiresChannel().antMatchers("/doReg").requiresSecure(); //使用https加密通道
		//		http.csrf().disable();//禁用csrf防护
		/**
		 * 这个简单的配置指定了该如何保护http请求,以及客户端认证用户的方案.通过调用authorizeRequests和anyRequest,authenticated就会要求所有进入应用的http请求都要进行认证.
		 */
	}

//	@Autowired
//	private UserServer userServer;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//todo 配置user-detail服务
		//todo SpringSecurity内置了多种常见的用户存储场景,如1内存2关系型数据库3LDAP
		inMemery( auth);
//		auth.userDetailsService(userServer).passwordEncoder(new BCryptPasswordEncoder());
	}


	private void inMemery(AuthenticationManagerBuilder auth) throws Exception {
		//todo 1.在内存中存放用户信息
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String defaultPassword = passwordEncoder.encode("123456");
		auth.inMemoryAuthentication().passwordEncoder(passwordEncoder)
			.withUser("zhz").password(defaultPassword).roles("admin","root")
			.and().withUser("root").password(defaultPassword).roles("root")
			.and().withUser("guide").password(defaultPassword).roles("user");
	}

	//	@Autowired
	//	private DataSource dataSource;
	//	private void byJdbc(AuthenticationManagerBuilder auth) throws Exception {
	//		//todo 2.配置jdbc
	//		auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder()).dataSource(dataSource)
	//			.usersByUsernameQuery("select username,password,true from account_login where username=?")
	//			.authoritiesByUsernameQuery("select username,'role_user' from from account_login where username=?");
	//	}

	//Lightweight Directory Access Protocol 轻量级目录访问协议
	private void byLDAP(AuthenticationManagerBuilder auth) throws Exception {
		//todo 3.配置LDAP协议
		auth.ldapAuthentication().userSearchBase("ou=people")
			.userSearchFilter("(uid=0)")
			.groupSearchBase("ou=groups")
			.groupSearchFilter("member={0}")
			.passwordCompare()//配置密码比对
			.passwordEncoder(new BCryptPasswordEncoder())
			.passwordAttribute("passcode");

		auth.ldapAuthentication()
			.contextSource().url("ldap://xxx.com:389/dc=a,dc=application");//访问远程地LDAP服务器
	}

	private void byUserDetailsService(AuthenticationManagerBuilder auth) throws Exception {
		//todo 4.通过自定义用户服务
		auth.userDetailsService(new UserDetailsService() {
			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				List<GrantedAuthority> authorities = new ArrayList<>();
				return new User("name","password",authorities) ;
			}
		});
	}
}
