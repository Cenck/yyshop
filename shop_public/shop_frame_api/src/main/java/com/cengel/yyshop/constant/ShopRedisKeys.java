package com.cengel.yyshop.constant;


/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 20:34
 * @Version V1.0
 **/
public class ShopRedisKeys {

	public interface EntityTableName{
		String TABLE_GOODS = "SHOP_GOODS";
		String TABLE_SECKILL = "SHOP_SECKILL";
	}

	public interface MenuMembers{
		String APP_MEMBER_LOGIN_DETAIL ="ameb_login_detail";
	}

	public interface MenuKeys{
		String RK_MENU_LEFT = "menu_left";
		String RF_MENU_LEFT_PREFIX = "i_";

		String RK_MENU_ITEM = "menu_item";
		String RF_MENU_ITEM_URI = "uri_";

		String RK_MENU_TOP = "menu_top";
	}

	public interface OrderKeys{
		//("统计第几位秒杀用户")
		String KEY_SECKILL_ORDER_COUNT = "seckill_count_";


	}
}
