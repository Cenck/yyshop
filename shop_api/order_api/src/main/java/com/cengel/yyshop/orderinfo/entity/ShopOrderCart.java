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
@Entity(name = "SHOP_ORDER_CART")
public class ShopOrderCart extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="USER_ID")
	private   String  userId;
	// 
	@Column(name="SESSION_ID")
	private   String  sessionId;
	// 
	// @NotNull(message = "不能为空!")
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
	@Column(name="MARKET_PRICE")
	private   java.math.BigDecimal  marketPrice;
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
	@Column(name="GIFTFLAG")
	private   String  giftflag;
	// 
	@Column(name="PROMOTEFLAG")
	private   String  promoteflag;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="SUIT_ID")
	private   String  suitId;
	// 
	@Column(name="SUIT_COUNT")
	private   String  suitCount;
	// 
	@Column(name="SUIT_GOODS_ID")
	private   String  suitGoodsId;
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