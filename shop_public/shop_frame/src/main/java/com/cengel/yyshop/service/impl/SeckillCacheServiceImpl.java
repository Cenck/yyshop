package com.cengel.yyshop.service.impl;

import com.cengel.redis.helper.RedisHelper;
import com.cengel.yyshop.service.SeckillCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.ShopRedisKeys.EntityTableName.TABLE_SECKILL;
import static com.cengel.yyshop.constant.ShopRedisKeys.OrderKeys.KEY_SECKILL_ORDER_COUNT;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 19:04
 * @Version V1.0
 **/
@Service
public class SeckillCacheServiceImpl extends BaseCacheServiceImpl implements SeckillCacheService {

	@Override
	String getEntityCacheKeyPrefix() {
		return TABLE_SECKILL;
	}

	@Autowired
	private RedisHelper redisHelper;

	@Override
	public void cacheSeckCount(Integer seckId, long time) {
		/********************|| 设置秒杀计数(第几个下单) ||********************/
		String redisKey = KEY_SECKILL_ORDER_COUNT + seckId;
		redisHelper.setAndExpire(redisKey, 0, time + 1000);
	}

	@Override
	public Integer incrSeckCount(Integer seckId) {
		return   redisHelper.incr(KEY_SECKILL_ORDER_COUNT + seckId);
	}

}
