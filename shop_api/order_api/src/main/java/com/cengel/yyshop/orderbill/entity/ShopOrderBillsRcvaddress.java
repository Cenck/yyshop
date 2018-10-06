package com.cengel.yyshop.orderbill.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_ORDER_BILLS_RCVADDRESS")
public class ShopOrderBillsRcvaddress extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="BILLS_ID")
	private   String  billsId;
	// 
	@Column(name="CONSIGNEE")
	private   String  consignee;
	// 
	@Column(name="EMAIL")
	private   String  email;
	// 
	@Column(name="COUNTRY")
	private   String  country;
	// 
	@Column(name="PROVINCE")
	private   String  province;
	// 
	@Column(name="CITY")
	private   String  city;
	// 
	@Column(name="DISTRICT")
	private   String  district;
	// 
	@Column(name="ADDRESS")
	private   String  address;
	// 
	@Column(name="ZIPCODE")
	private   String  zipcode;
	// 
	@Column(name="TEL")
	private   String  tel;
	// 
	@Column(name="MOBILE")
	private   String  mobile;
	// 
	@Column(name="SIGN_BUILDING")
	private   String  signBuilding;
	// 
	@Column(name="BEST_TIME")
	private   String  bestTime;
	// 
	@Column(name="BEST_DATE")
	private   String  bestDate;
	// 
	@Column(name="PAY_ID")
	private   String  payId;
	// 
	@Column(name="SHIPPING_ID")
	private   String  shippingId;
	// 
	@Column(name="INVITE_ID")
	private   String  inviteId;
	// 
	@Column(name="LEV_FIELD1")
	private   String  levField1;
	// 
	@Column(name="LEV_FIELD2")
	private   String  levField2;
	// 
	@Column(name="LEV_FIELD3")
	private   String  levField3;
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