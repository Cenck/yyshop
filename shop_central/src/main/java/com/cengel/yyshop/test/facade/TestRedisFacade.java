package com.cengel.yyshop.test.facade;

import com.cengel.starbucks.demo.Goods;

public interface TestRedisFacade {

	Goods testGoodsToRedis(Integer id);

	Goods testRedisCache();


}
