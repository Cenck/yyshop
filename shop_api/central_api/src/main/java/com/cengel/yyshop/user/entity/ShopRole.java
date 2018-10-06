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
@Entity(name = "SHOP_ROLE")
public class ShopRole extends BaseEntity<Integer> {

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
	@Column(name="ROLE_NAME")
	private   String  roleName;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ROLE_CODE")
	private   String  roleCode;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="IS_ENABLE")
	private   String  isEnable;
	// 
	@Column(name="ROLE_DESC")
	private   String  roleDesc;
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