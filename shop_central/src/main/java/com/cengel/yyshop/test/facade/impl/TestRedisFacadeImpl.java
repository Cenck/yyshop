package com.cengel.yyshop.test.facade.impl;

import com.cengel.redis.annotation.RedisCache;
import com.cengel.starbucks.demo.Goods;
import com.cengel.yyshop.test.facade.TestRedisFacade;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/26 - 9:24
 * @Version V1.0
 **/
@Service
public class TestRedisFacadeImpl implements TestRedisFacade {

	@Override
	@RedisCache(key = "#p0",expire = 100)
	public Goods testGoodsToRedis(Integer id) {
		Goods goods= new Goods();
		goods.setPrice(new BigDecimal(id));
		goods.setName("x");
		goods.setStock(id);
		return goods;
	}

	@Override
	public Goods testRedisCache() {
		return testGoodsToRedis(1);
	}
}
