package com.cengel.yyshop.orderinfo.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_ORDER_SERVINFO")
public class ShopOrderServinfo extends BaseEntity<Integer> {

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
	@Column(name="SERVICE_SN")
	private   String  serviceSn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_SN")
	private   String  orderSn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="DELIVERY_SN")
	private   String  deliverySn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ADDRESS_ID")
	private   String  addressId;
	// 
	@Column(name="DELIVERY_TIME")
	private   String  deliveryTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="GOODS_SN")
	private   String  goodsSn;
	// 
	@Column(name="GOODS_NAME")
	private   String  goodsName;
	// 
	@Column(name="CONTACT")
	private   String  contact;
	// 
	@Column(name="ADRESS")
	private   String  adress;
	// 
	@Column(name="PHONE")
	private   String  phone;
	// 
	@Column(name="INSTALLDEMAND")
	private   String  installdemand;
	// 
	@Column(name="DISPACH_STATE")
	private   String  dispachState;
	// 
	@Column(name="INSTALLER")
	private   String  installer;
	// 
	@Column(name="INSTALLER_ID")
	private   String  installerId;
	// 
	@Column(name="INSTALLTIME")
	private   String  installtime;
	// 
	@Column(name="INSTALL_SERVINFO")
	private   String  installServinfo;
	// 
	@Column(name="INSTALLMOBLE")
	private   String  installmoble;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="INSTALLPHONE")
	private   String  installphone;
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