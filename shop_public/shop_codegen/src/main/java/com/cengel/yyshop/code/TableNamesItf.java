package com.cengel.yyshop.code;

import com.cengel.starbucks.annotation.Description;

public interface TableNamesItf {

	String USER = "shop_user,shop_user_role,shop_role,shop_role_menu,shop_menu,shop_user_menu";

	String GOODS = "shop_goods,shop_goods_brand,shop_goods_gallery,shop_goods_link,shop_goods_article_link,shop_goods_suit,shop_goods_suit_link,shop_goods_products";

	@Description("描述产品属性")
	String PROPERTY ="shop_goods_mark,shop_goods_spec,shop_goods_spec_value,shop_goods_spec_link,shop_goods_stock,shop_goods_attr_link,shop_goods_attr_value,shop_goods_attr,";

	String CATEGORY = "shop_goods_category,shop_goods_type,shop_goods_type_attr,shop_goods_type_spec,shop_goods_virtual_category,";


	String ORDER_INFO = "shop_order_address,shop_order_cart,shop_order_delivinfo,shop_order_favorinfo,shop_order_goods,shop_order_info,shop_order_infob,shop_order_loginfo,shop_order_mark,shop_order_servinfo,shop_order_stockout,shop_order_type";
	String ORDER_BILL = "shop_order_bills,shop_order_bills_delivinfo,shop_order_bills_goods,shop_order_bills_rcvaddress,";
	String ORDER_PROMO="shop_order_promotions,shop_promotions,shop_promotions_rule,shop_promotions_rule_goods,shop_promotions_rule_rank,shop_seckill,shop_seckill_order,";

	String MEMBER ="shop_member,shop_member_rank,shop_member_authority,shop_member_collection,shop_member_funds,shop_member_address";
	String SYS = "";



}
