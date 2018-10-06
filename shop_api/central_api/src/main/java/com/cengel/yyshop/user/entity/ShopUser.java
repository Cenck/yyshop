package com.cengel.yyshop.user.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：后台管理员
*/
@Getter
@Setter
@Entity(name = "SHOP_USER")
public class ShopUser extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 代理商id
	@Column(name="AGENCY_ID")
	private   String  agencyId;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="USER_NAME")
	private   String  userName;
	// 
	@Column(name="NICK_NAME")
	private   String  nickName;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="PASSWORD")
	private   String  password;
	// 
	@Column(name="EMAIL")
	private   String  email;
	// 
	@Column(name="LOCKED")
	private   String  locked;
	// 
	@Column(name="EXPIRED")
	private   String  expired;
	// 用户角色
	@Column(name="USER_ROLES")
	private   String  userRoles;
	// 
	@Column(name="LAST_LOGIN_TIME")
	private   String  lastLoginTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="LAST_LOGIN_IP")
	private   String  lastLoginIp;
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