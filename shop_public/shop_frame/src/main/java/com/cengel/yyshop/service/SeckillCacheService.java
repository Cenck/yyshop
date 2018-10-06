package com.cengel.yyshop.service;

public interface SeckillCacheService extends BaseCacheService {

	/**
	 * 创建秒杀商品时，处理缓存
	 * @param seckId
	 */
	void cacheSeckCount(Integer seckId, long time);
	//下单人数+1
	Integer incrSeckCount(Integer seckId);

}
