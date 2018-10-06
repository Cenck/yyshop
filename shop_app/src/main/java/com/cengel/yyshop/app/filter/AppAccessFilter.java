package com.cengel.yyshop.app.filter;

import com.cengel.redis.helper.RedisSessionHelper;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.enums.PlatformEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 12:25
 * @Version V1.0
 **/
@Component
public class AppAccessFilter extends OncePerRequestFilter {

	@Autowired
	private RedisSessionHelper redisSessionHelper;

	@Override
	protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserHolder.setUser(redisSessionHelper.getUser(userDetails.getUsername(), PlatformEnum.APP.getCode()));
		}
		filterChain.doFilter(httpServletRequest, httpServletResponse);
	}
}
