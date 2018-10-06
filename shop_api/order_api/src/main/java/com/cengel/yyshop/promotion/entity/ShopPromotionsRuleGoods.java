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
@Entity(name = "SHOP_PROMOTIONS_RULE_GOODS")
public class ShopPromotionsRuleGoods extends BaseEntity<Integer> {

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
	private   String  ruleId;
	// 
	@Column(name="FREE_ID")
	private   String  freeId;
	// 
	@Column(name="BARGAINS_ID")
	private   String  bargainsId;
	// 
	@Column(name="BARGAINS_PRICE")
	private   java.math.BigDecimal  bargainsPrice;
	// 
	@Column(name="BARGAINS_NUM")
	private   java.math.BigDecimal  bargainsNum;
	// 
	@Column(name="FREE_NUM")
	private   java.math.BigDecimal  freeNum;
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