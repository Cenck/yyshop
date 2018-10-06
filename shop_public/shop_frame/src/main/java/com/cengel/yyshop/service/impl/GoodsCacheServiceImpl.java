package com.cengel.yyshop.service.impl;

import com.cengel.yyshop.service.GoodsCacheService;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.ShopRedisKeys.EntityTableName.TABLE_GOODS;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 18:37
 * @Version V1.0
 **/
@Service
public class GoodsCacheServiceImpl extends BaseCacheServiceImpl implements GoodsCacheService {

	@Override
	String getEntityCacheKeyPrefix() {
		return TABLE_GOODS;
	}


}
