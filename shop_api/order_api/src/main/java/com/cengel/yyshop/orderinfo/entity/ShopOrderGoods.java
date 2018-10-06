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
@Entity(name = "SHOP_ORDER_GOODS")
public class ShopOrderGoods extends BaseEntity<Integer> {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;

	// ~~~~实体属性
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "ORDER_ID")
	private Integer              orderId;
	@Column(name = "DISCOUNT_PRICE")
	private java.math.BigDecimal discountPrice;
	// 
	@Column(name = "ORDER_SN")
	private String               orderSn;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "GOODS_ID")
	private Integer              goodsId;
	// 
	@Column(name = "PRODUCT_ID")
	private Integer              productId;
	// 
	@Column(name = "GOODS_SN")
	private String               goodsSn;
	// 
	@Column(name = "PRODUCT_SN")
	private String               productSn;
	// 
	@Column(name = "GOODS_NAME")
	private String               goodsName;
	// 
	@Column(name = "PRODUCT_NAME")
	private String               productName;
	// 
	@Column(name = "GOODS_DOUBLE")
	private java.math.BigDecimal goodsDouble;
	// 
	@Column(name = "SALES_PRICE")
	private java.math.BigDecimal salesPrice;
	// 
	@Column(name = "SELLTYPE")
	private String               selltype;
	//
	@Column(name = "IS_REAL")
	private Boolean              isReal;
	// 
	@Column(name = "EXTENSION_CODE")
	private String               extensionCode;
	// 
	@Column(name = "PARENT_ID")
	private String               parentId;
	// 
	@Column(name = "OPERATOR")
	private String               operator;
	// 
	@Column(name = "GIFTFLAG")
	private String               giftflag;
	// 
	@Column(name = "PROMOTEFLAG")
	private String               promoteflag;
	// 
	@Column(name = "IS_SUIT")
	private Boolean              isSuit;
	// 
	@Column(name = "SUIT_ID")
	private String               suitId;
	// 
	@Column(name = "START_DATE")
	private String               startDate;
	// 
	@Column(name = "SUIT_TYPE")
	private String               suitType;
	// 
	@Column(name = "END_DATE")
	private String               endDate;
	// 
	@Column(name = "SUIT_COUNT")
	private java.math.BigDecimal suitCount;
	// 
	@Column(name = "GOODS_REST_NUM")
	private java.math.BigDecimal goodsRestNum;
	// 
	@Column(name = "INTEGRAL")
	private java.math.BigDecimal integral;
	// 
	@Column(name = "INTEGRAL_MONEY")
	private java.math.BigDecimal integralMoney;
	// 
	@Column(name = "PROMOTIONS_MONEY")
	private java.math.BigDecimal promotionsMoney;
	// 
	@Column(name = "COUPONS_MONEY")
	private java.math.BigDecimal couponsMoney;
	// 
	@Column(name = "GCARD_MONEY")
	private java.math.BigDecimal gcardMoney;
	//
	// @NotNull(message = "不能为空!")
	@Column(name = "CREATE_TIME")
	private java.util.Date       createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "MODIFIED_TIME")
	private java.util.Date       modifiedTime;
	// 
	@Column(name = "CREATE_BY")
	private String               createBy;
	// 
	@Column(name = "MODIFIED_BY")
	private String               modifiedBy;

}