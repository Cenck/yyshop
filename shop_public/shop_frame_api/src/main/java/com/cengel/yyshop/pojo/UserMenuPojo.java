package com.cengel.yyshop.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/30 - 20:23
 * @Version V1.0
 **/
@Data
public class UserMenuPojo implements Serializable {

	private Integer            topId;//一级父类id
	private Boolean            isActive;//是否为当前选中菜单
	private List<UserMenuPojo> children;

	private Integer              id;
	private Integer              deleted;
	private Integer              menuLevel;
	private String               platform;
	private Integer              parentId;
	private String               menuName;
	private String               menuUrl;
	private java.math.BigDecimal sortOrder;
	private String               isDefault;
	private String               permission;
	private java.util.Date       createTime;
	private java.util.Date       modifiedTime;
	private String               createBy;
	private String               modifiedBy;

}
