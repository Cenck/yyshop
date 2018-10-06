package com.cengel.yyshop.goods.dto;

import com.cengel.yyshop.goods.entity.ShopGoods;
import lombok.Data;

/**
 * @Title: 较为完整的商品信息
 * @Description:
 * @Author zhz
 * @Time 2018/8/3 - 17:29
 * @Version V1.0
 **/
@Data
public class ShopGoodsInfoDto extends ShopGoods {

	private String productsNo;
	private String productsName;

}
