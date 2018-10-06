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
@Entity(name = "SHOP_ORDER_FAVORINFO")
public class ShopOrderFavorinfo extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="FAVOR_SN")
	private   String  favorSn;
	// 
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 
	@Column(name="ORDER_SN")
	private   String  orderSn;
	// 
	@Column(name="FAVOR_TYPE")
	private   String  favorType;
	// 
	@Column(name="MONEY")
	private   java.math.BigDecimal  money;
	// 
	@Column(name="REMARK")
	private   String  remark;
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