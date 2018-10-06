package com.cengel.yyshop.central.facade;

import com.cengel.starbucks.annotation.Description;
import com.cengel.starbucks.model.obj.Response;

public interface MUserFacade {

	@Description("刷新所有缓存菜单")
	Response refreshAll();
}
