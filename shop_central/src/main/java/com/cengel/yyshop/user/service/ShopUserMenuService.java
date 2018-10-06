package com.cengel.yyshop.user.service;

import com.cengel.hibernate.service.BaseService;
import com.cengel.starbucks.annotation.Description;
import com.cengel.yyshop.pojo.UserMenuPojo;
import com.cengel.yyshop.user.entity.ShopUserMenu;

import java.util.List;

/**
 * 业务层：
 */
public interface ShopUserMenuService  extends BaseService<ShopUserMenu, Integer>  {
	ShopUserMenu getMenuByUri(String uri);

	@Description("一级菜单")
	List<ShopUserMenu> findByParentId(int parentId);
	List<ShopUserMenu> findTopMenus();
	List<UserMenuPojo> findAllMenus();

	/********************|| 缓存用 ||********************/
	//拿到某个一级菜单下的所以二三级菜单
	List<UserMenuPojo> findAndCacheLeftMenus(int topMenuId);
	List<UserMenuPojo> findPojoByParentId(int parentId);
	List<UserMenuPojo> findAndCacheTopMenus();

}
