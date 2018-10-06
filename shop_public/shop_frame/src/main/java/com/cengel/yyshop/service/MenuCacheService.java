package com.cengel.yyshop.service;

import com.cengel.yyshop.pojo.UserMenuPojo;

import java.util.List;

public interface MenuCacheService {

	UserMenuPojo getMenuByUri(String uri);
	void setMenuByUri(String uri,UserMenuPojo pojo);

	List<UserMenuPojo> getListMenus(int topId);
	void putLeftMenus(int parentId, List<UserMenuPojo> menuDtos);

	List<UserMenuPojo> getTopMenus();
	void putTopMenus(List<UserMenuPojo> list);

}
