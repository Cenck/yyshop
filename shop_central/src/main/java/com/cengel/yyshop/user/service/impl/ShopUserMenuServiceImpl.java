package com.cengel.yyshop.user.service.impl;

import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.starbucks.exception.BusinessException;
import com.cengel.starbucks.util.ObjectUtil;
import com.cengel.starbucks.util.Validator;
import com.cengel.yyshop.pojo.UserMenuPojo;
import com.cengel.yyshop.service.MenuCacheService;
import com.cengel.yyshop.user.entity.ShopUserMenu;
import com.cengel.yyshop.user.service.ShopUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 业务层：
 */
@Service
public class ShopUserMenuServiceImpl extends BaseServiceImpl<ShopUserMenu, Integer> implements ShopUserMenuService {

	@Autowired
	private MenuCacheService menuCacheService;

	@Override
	public void saveOrUpdate(ShopUserMenu shopUserMenu) {
		if (Validator.isNotBlank(shopUserMenu.getMenuUrl())&& !Validator.isUri(shopUserMenu.getMenuUrl())){
			throw new BusinessException("不合法的uri");
		}
		if (shopUserMenu.getParentId() == null) shopUserMenu.setParentId(0);
		if (shopUserMenu.getParentId() > 0) {
			ShopUserMenu parent = get(shopUserMenu.getParentId());
			if (parent == null || parent.getMenuLevel() == null) parent.setMenuLevel(-1);
			int parentLv = parent.getMenuLevel();
			shopUserMenu.setMenuLevel(++parentLv);
		}
		if (shopUserMenu.getIsDefault()==null) shopUserMenu.setIsDefault("0");
		if (shopUserMenu.getPermission()==null) shopUserMenu.setPermission("*");
		if (shopUserMenu.getMenuLevel()==null) shopUserMenu.setMenuLevel(0);

		super.saveOrUpdate(shopUserMenu);
	}

	@Override
	public ShopUserMenu getMenuByUri(String uri) {
		ShopUserMenu temp = new ShopUserMenu();
		temp.setDeleted(false);
		temp.setMenuUrl(uri);
		List<ShopUserMenu> list = find(temp);
		if (ObjectUtil.isNotNull(list)) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<ShopUserMenu> findTopMenus() {
		ShopUserMenu temp = new ShopUserMenu();
		temp.setDeleted(false);
		temp.setMenuLevel(0);
		return find(temp);
	}

	@Override
	public List<UserMenuPojo> findAllMenus() {
		//一级菜单
		List<UserMenuPojo> _top = findAndCacheTopMenus();
		for (UserMenuPojo pojo : _top) {
			// 二级菜单
			List<UserMenuPojo> _left = findPojoByParentId(pojo.getId());
			for (UserMenuPojo userMenuPojo : _left) {
				List<UserMenuPojo> _central = findPojoByParentId(userMenuPojo.getId());
				userMenuPojo.setChildren(_central);
			}
			pojo.setChildren(_left);
		}
		return _top;
	}

	@Override
	public List<UserMenuPojo> findAndCacheLeftMenus(int topMenuId) {
		List<UserMenuPojo> _secondList = findPojoByParentId(topMenuId);
		for (UserMenuPojo dto : _secondList) {
			dto.setChildren(findPojoByParentId(dto.getId()));
		}
		menuCacheService.putLeftMenus(topMenuId, _secondList);
		return _secondList;
	}

	@Override
	public List<ShopUserMenu> findByParentId(int parentId) {
		ShopUserMenu temp = new ShopUserMenu();
		temp.setDeleted(false);
		temp.setParentId(parentId);
		return find(temp);
	}

	@Override
	public List<UserMenuPojo> findPojoByParentId(int parentId) {
		List<UserMenuPojo> list = getBaseDao().listDTO("select id,MENU_LEVEL menuLevel,PLATFORM platform,PARENT_ID parentId,MENU_NAME menuName,MENU_URL menuUrl,SORT_ORDER sortOrder,DELETED deleted,IS_DEFAULT isDefault,PERMISSION permission from shop_user_menu where DELETED=0 and PARENT_ID = " + parentId, UserMenuPojo.class);
		for (UserMenuPojo dto : list) {
			switch (dto.getMenuLevel()) {
				case 0: dto.setTopId(dto.getId());
					break;
				case 1: dto.setTopId(dto.getParentId());
					break;
				case 2: dto.setTopId(get(dto.getParentId()).getParentId());
					break;
			}

			if (Validator.isUri(dto.getMenuUrl())) {
				//todo 把每一个uri不为空的菜单 放进redis
				menuCacheService.setMenuByUri(dto.getMenuUrl(), dto);
			}
		}

		return list;
	}

	@Override
	public List<UserMenuPojo> findAndCacheTopMenus() {
		List<UserMenuPojo> list = getBaseDao().listDTO("select id,id topId,MENU_LEVEL menuLevel,PLATFORM platform,PARENT_ID parentId,MENU_NAME menuName,MENU_URL menuUrl,SORT_ORDER sortOrder,DELETED deleted,IS_DEFAULT isDefault,PERMISSION permission from shop_user_menu where DELETED=0 and MENU_LEVEL = 0 ", UserMenuPojo.class);
		menuCacheService.putTopMenus(list);
		for (UserMenuPojo pojo : list) {
			this.findAndCacheLeftMenus(pojo.getId());
			if (Validator.isUri(pojo.getMenuUrl())) {
				//todo 把每一个uri不为空的菜单 放进redis
				menuCacheService.setMenuByUri(pojo.getMenuUrl(), pojo);
			}
		}
		return list;
	}
}
