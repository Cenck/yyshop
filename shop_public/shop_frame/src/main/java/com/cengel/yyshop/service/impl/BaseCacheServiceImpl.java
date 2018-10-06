package com.cengel.yyshop.service.impl;

import com.cengel.redis.helper.RedisHelper;
import com.cengel.yyshop.service.BaseCacheService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 20:17
 * @Version V1.0
 **/
public abstract class BaseCacheServiceImpl implements BaseCacheService {
	abstract String getEntityCacheKeyPrefix();

	@Autowired
	private RedisHelper redisHelper;
	@Override
	public Serializable get(Integer id) {
		return redisHelper.get(getEntityCacheKeyPrefix()+id);
	}

	@Override
	public void set(Integer id, Serializable entity) {
		redisHelper.set(getEntityCacheKeyPrefix()+id,entity);
	}
}
