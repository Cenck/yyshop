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
@Entity(name = "SHOP_ORDER_DELIVINFO")
public class ShopOrderDelivinfo extends BaseEntity<Integer> {

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
	@Column(name="DELIVERY_SN")
	private   String  deliverySn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_SN")
	private   String  orderSn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 
	@Column(name="LOGISTICS_SN")
	private   String  logisticsSn;
	// 
	@Column(name="COMPANY")
	private   String  company;
	// 
	@Column(name="STATUS")
	private   String  status;
	// 
	@Column(name="DELIVERYTIME")
	private   String  deliverytime;
	// 
	@Column(name="PRINTSTATE")
	private   String  printstate;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="COMPANYCODE")
	private   String  companycode;
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