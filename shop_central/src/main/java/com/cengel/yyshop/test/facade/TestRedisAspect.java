package com.cengel.yyshop.test.facade;

import com.cengel.redis.annotation.RedisCache;
import com.cengel.redis.helper.RedisHelper;
import com.cengel.starbucks.demo.Goods;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/26 - 9:39
 * @Version V1.0
 **/
@Slf4j
@Component
@Aspect
public class TestRedisAspect {

	@Autowired
	private RedisHelper redisHelper;

	@Around("execution(public * com.cengel.yyshop..*.*RedisCache(..))")
	public Object aroundAnnotation(ProceedingJoinPoint point) {
		Object o = null;
		try {
			o = point.proceed();
			if (!(o instanceof Serializable)) {
				throw new IllegalArgumentException("redis等持久化对象未实现可序列化接口");
			}
		} catch (Throwable throwable) {
			throw new RuntimeException("");
		}
		return o;
	}

}
