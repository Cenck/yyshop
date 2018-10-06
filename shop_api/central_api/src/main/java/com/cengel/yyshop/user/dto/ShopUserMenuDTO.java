package com.cengel.yyshop.user.dto;

import com.cengel.yyshop.user.entity.ShopUserMenu;
import lombok.Data;

import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 20:49
 * @Version V1.0
 **/
@Data
public class ShopUserMenuDTO extends ShopUserMenu {
	private List<ShopUserMenuDTO> children;
}
