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
@Entity(name = "SHOP_ORDER_BILLS_DELIVINFO")
public class ShopOrderBillsDelivinfo extends BaseEntity<Integer> {

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
	@Column(name="DELIVERY_SN")
	private   String  deliverySn;
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
	@Column(name="LEV_FIELD1")
	private   String  levField1;
	// 
	@Column(name="LEV_FIELD2")
	private   String  levField2;
	// 
	@Column(name="LEV_FIELD3")
	private   String  levField3;
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