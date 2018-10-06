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
@Entity(name = "SHOP_ORDER_BILLS_GOODS")
public class ShopOrderBillsGoods extends BaseEntity<Integer> {

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
	@Column(name="BILLS_SN")
	private   String  billsSn;
	// 
	@Column(name="GOODS_ID")
	private   String  goodsId;
	// 
	@Column(name="PRODUCT_ID")
	private   String  productId;
	// 
	@Column(name="GOODS_SN")
	private   String  goodsSn;
	// 
	@Column(name="PRODUCT_SN")
	private   String  productSn;
	// 
	@Column(name="GOODS_NAME")
	private   String  goodsName;
	// 
	@Column(name="PRODUCT_NAME")
	private   String  productName;
	// 
	@Column(name="GOODS_DOUBLE")
	private   java.math.BigDecimal  goodsDouble;
	// 
	@Column(name="SALES_PRICE")
	private   java.math.BigDecimal  salesPrice;
	// 
	@Column(name="SELLTYPE")
	private   String  selltype;
	// 
	@Column(name="IS_REAL")
	private   String  isReal;
	// 
	@Column(name="EXTENSION_CODE")
	private   String  extensionCode;
	// 
	@Column(name="PARENT_ID")
	private   String  parentId;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="GIFTFLAG")
	private   String  giftflag;
	// 
	@Column(name="PROMOTEFLAG")
	private   String  promoteflag;
	// 
	@Column(name="IS_SUIT")
	private   String  isSuit;
	// 
	@Column(name="SUIT_ID")
	private   String  suitId;
	// 
	@Column(name="START_DATE")
	private   String  startDate;
	// 
	@Column(name="END_DATE")
	private   String  endDate;
	// 
	@Column(name="SUIT_TYPE")
	private   String  suitType;
	// 
	@Column(name="SUIT_COUNT")
	private   java.math.BigDecimal  suitCount;
	// 
	@Column(name="GOODS_REST_NUM")
	private   java.math.BigDecimal  goodsRestNum;
	// 
	@Column(name="LEV_FIELD3")
	private   String  levField3;
	// 
	@Column(name="LEV_FIELD4")
	private   String  levField4;
	// 
	@Column(name="LEV_FIELD5")
	private   String  levField5;
	// 
	@Column(name="INTEGRAL")
	private   java.math.BigDecimal  integral;
	// 
	@Column(name="INTEGRAL_MONEY")
	private   java.math.BigDecimal  integralMoney;
	// 
	@Column(name="PROMOTIONS_MONEY")
	private   java.math.BigDecimal  promotionsMoney;
	// 
	@Column(name="COUPONS_MONEY")
	private   java.math.BigDecimal  couponsMoney;
	// 
	@Column(name="GCARD_MONEY")
	private   java.math.BigDecimal  gcardMoney;
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