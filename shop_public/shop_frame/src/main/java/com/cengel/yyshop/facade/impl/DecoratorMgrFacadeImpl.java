package com.cengel.yyshop.facade.impl;

import com.cengel.yyshop.facade.DecoratorMgrFacade;
import com.cengel.yyshop.pojo.UserMenuPojo;
import com.cengel.yyshop.service.MenuCacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 13:07
 * @Version V1.0
 **/
@Service
public class DecoratorMgrFacadeImpl implements DecoratorMgrFacade {

	@Autowired
	private MenuCacheService menuCacheService;

	@Override
	public void buildDecorator(ModelMap modelMap) {
		final String uri = modelMap.get("uri").toString();
		List<UserMenuPojo> list = menuCacheService.getTopMenus();

		for (UserMenuPojo pojo : list) {
			if (pojo.getMenuUrl() != null && pojo.getMenuUrl().contains(getUriIdentity(uri))) {
				pojo.setIsActive(true);
			}
		}
		modelMap.put("TopMenusList", list);

		//二级菜单
		UserMenuPojo pojo = menuCacheService.getMenuByUri(uri);
		if (pojo != null) {
			//todo 3级菜单 才有
			List<UserMenuPojo> leftList = menuCacheService.getListMenus(pojo.getTopId());
			A: for (UserMenuPojo userMenuPojo : leftList) {
				if (userMenuPojo.getChildren()!=null)  for (UserMenuPojo child : userMenuPojo.getChildren()) {
					if (uri.equals(child.getMenuUrl())){
						child.setIsActive(true);
						userMenuPojo.setIsActive(true);
						break A;
					}
				}
			}
			modelMap.put("LeftMenusList", leftList );
		}
	}

	private String getUriIdentity(String uri) {
		//返回/m/uc
		StringBuilder sb = new StringBuilder();
		Pattern pattern = Pattern.compile("/[a-zA-z0-9]{0,20}");
		Matcher matcher = pattern.matcher(uri);
		int count = 0;
		while (matcher.find()) {
			if (count < 3 && count > 0) sb.append(matcher.group());
			count++;
		}
		return sb.toString();
	}

}
