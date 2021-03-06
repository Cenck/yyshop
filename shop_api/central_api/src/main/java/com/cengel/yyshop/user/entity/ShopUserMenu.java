package com.cengel.yyshop.user.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_USER_MENU")
public class ShopUserMenu extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="MENU_LEVEL")
	private   Integer  menuLevel;
	// 
	@Column(name="PLATFORM")
	private   String  platform;
	// 
	@Column(name="PARENT_ID")
	private   Integer  parentId;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="MENU_NAME")
	private   String  menuName;
	// 
	@Column(name="MENU_URL")
	private   String  menuUrl;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="SORT_ORDER")
	private   java.math.BigDecimal  sortOrder;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="IS_DEFAULT")
	private   String  isDefault;
	// 有权限的角色
	// @NotNull(message = "有权限的角色不能为空!")
	@Column(name="PERMISSION")
	private   String  permission;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="CREATE_TIME")
	private   java.util.Date  createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="MODIFIED_TIME")
	private   java.util.Date  modifiedTime;
	// 
	@Column(name="CREATE_BY")
	private   String  createBy;
	// 
	@Column(name="MODIFIED_BY")
	private   String  modifiedBy;

}