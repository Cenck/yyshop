package com.cengel.yyshop.service.impl;

import com.cengel.redis.helper.RedisHelper;
import com.cengel.starbucks.mapper.JsonMapper;
import com.cengel.yyshop.pojo.UserMenuPojo;
import com.cengel.yyshop.service.MenuCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.cengel.yyshop.constant.ShopRedisKeys.MenuKeys.*;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 20:21
 * @Version V1.0
 **/
@Service
public class MenuCacheServiceImpl implements MenuCacheService {

	@Autowired
	private RedisHelper redisHelper;

	@Override
	public UserMenuPojo getMenuByUri(String uri) {
		return redisHelper.hget(RK_MENU_ITEM, RF_MENU_ITEM_URI + uri);
	}

	@Override
	public void setMenuByUri(String uri, UserMenuPojo pojo) {
		redisHelper.hset(RK_MENU_ITEM, RF_MENU_ITEM_URI + uri, pojo);
	}

	@Override
	public List<UserMenuPojo> getListMenus(int topId) {
		String jsonStr = redisHelper.hget(RK_MENU_LEFT, RF_MENU_LEFT_PREFIX + topId);
		return JsonMapper.getMapper().fromJson(jsonStr, JsonMapper.getMapper().createCollectionType(List.class, UserMenuPojo.class));
	}

	@Override
	public void putLeftMenus(int topId, List<UserMenuPojo> menuDtos) {
		redisHelper.hset(RK_MENU_LEFT, RF_MENU_LEFT_PREFIX + topId, JsonMapper.getMapper().toJson(menuDtos));
	}

	@Override
	public List<UserMenuPojo> getTopMenus() {
		String jsonStr = redisHelper.get(RK_MENU_TOP);
		return JsonMapper.getMapper().fromJson(jsonStr, JsonMapper.getMapper().createCollectionType(List.class, UserMenuPojo.class));
	}

	@Override
	public void putTopMenus(List<UserMenuPojo> list) {
		redisHelper.set(RK_MENU_TOP,JsonMapper.getMapper().toJson(list));
	}
}
