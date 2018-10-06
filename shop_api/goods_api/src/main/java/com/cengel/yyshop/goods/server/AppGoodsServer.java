package com.cengel.yyshop.goods.server;

import com.cengel.starbucks.model.obj.Response;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 12:18
 * @Version V1.0
 **/
public interface AppGoodsServer {
	Integer HOME_BANNER_LEN = 5;

	Response home();
}
