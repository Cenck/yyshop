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
@Entity(name = "SHOP_ORDER_STOCKOUT")
public class ShopOrderStockout extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="STOCKOUT_SN")
	private   String  stockoutSn;
	// 
	@Column(name="USER_ID")
	private   String  userId;
	// 
	@Column(name="GOODSNAME")
	private   String  goodsname;
	// 
	@Column(name="CONTACT")
	private   String  contact;
	// 
	@Column(name="ENTERTIME")
	private   String  entertime;
	// 
	@Column(name="STOCKDOUBLE")
	private   java.math.BigDecimal  stockdouble;
	// 
	@Column(name="PHONE")
	private   String  phone;
	// 
	@Column(name="INTRODUCTIONS")
	private   String  introductions;
	// 
	@Column(name="STATE")
	private   String  state;
	// 
	@Column(name="REPLY")
	private   String  reply;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
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