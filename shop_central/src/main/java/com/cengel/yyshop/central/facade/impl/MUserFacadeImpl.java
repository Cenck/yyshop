package com.cengel.yyshop.central.facade.impl;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.central.facade.MUserFacade;
import com.cengel.yyshop.user.service.ShopUserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 20:16
 * @Version V1.0
 **/
@Service
public class MUserFacadeImpl implements MUserFacade {

	@Autowired
	private ShopUserMenuService menuService;

	@Override
	public Response refreshAll() {
		menuService.findAndCacheTopMenus();
		return Response.success();
	}
}
