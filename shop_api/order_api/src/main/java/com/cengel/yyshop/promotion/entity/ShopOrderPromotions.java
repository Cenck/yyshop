package com.cengel.yyshop.promotion.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_ORDER_PROMOTIONS")
public class ShopOrderPromotions extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="PROMOTIONID")
	private   String  promotionid;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="RULEID")
	private   String  ruleid;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_SN")
	private   String  orderSn;
	// 
	@Column(name="REMARK")
	private   String  remark;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="DISCOUNTRATE")
	private   java.math.BigDecimal  discountrate;
	// 
	@Column(name="DISCOUNTMONEY")
	private   java.math.BigDecimal  discountmoney;
	// 
	@Column(name="DERATEMONEY")
	private   java.math.BigDecimal  deratemoney;
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