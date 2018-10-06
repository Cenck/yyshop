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
@Entity(name = "SHOP_PROMOTIONS_RULE")
public class ShopPromotionsRule extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="PROMOTIONS_ID")
	private   String  promotionsId;
	// 
	@Column(name="RULE_ID")
	private   java.math.BigDecimal  ruleId;
	// 
	@Column(name="GIFT_DOUBLE")
	private   java.math.BigDecimal  giftDouble;
	// 
	@Column(name="DISCOUNT_RATE")
	private   java.math.BigDecimal  discountRate;
	// 
	@Column(name="IS_NO_SHIPPING_FEE")
	private   java.math.BigDecimal  isNoShippingFee;
	// 
	@Column(name="OF_FEE")
	private   java.math.BigDecimal  ofFee;
	// 
	@Column(name="SORT_ORDER")
	private   java.math.BigDecimal  sortOrder;
	// 
	@Column(name="DESCRIPTION")
	private   String  description;
	// 
	@Column(name="SUM_FEE")
	private   java.math.BigDecimal  sumFee;
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