package com.cengel.yyshop.service.impl;

import com.cengel.redis.annotation.RedisCache;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.enums.PlatformEnum;
import com.cengel.yyshop.service.UserCacheService;
import org.springframework.stereotype.Service;

@Service
public class UserCacheServiceImpl implements UserCacheService {

	@Override
	@RedisCache(key="$demo")
	public OnlineUser getDemoManager() {
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setId(1);
		onlineUser.setDistId(882);
		onlineUser.setNickName("管家组");
		onlineUser.setRealName("张三");
		onlineUser.setPlatform(PlatformEnum.MGR.getCode());
		return onlineUser;
	}
}
