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
@Entity(name = "SHOP_ORDER_INFOB")
public class ShopOrderInfob extends BaseEntity<Integer> {

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
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 
	@Column(name="ORDER_SN")
	private   String  orderSn;
	// 
	@Column(name="USER_ID")
	private   String  userId;
	// 
	@Column(name="ORDER_STATUS")
	private   String  orderStatus;
	// 
	@Column(name="ADDRESS_ID")
	private   String  addressId;
	// 
	@Column(name="SHIPPING_STATUS")
	private   String  shippingStatus;
	// 
	@Column(name="PAY_STATUS")
	private   String  payStatus;
	// 
	@Column(name="SHIPPING_ID")
	private   String  shippingId;
	// 
	@Column(name="SHIPPING_TIME")
	private   String  shippingTime;
	// 
	@Column(name="IS_COD")
	private   String  isCod;
	// 
	@Column(name="PAY_ID")
	private   String  payId;
	// 
	@Column(name="TRADE_NO")
	private   String  tradeNo;
	// 
	@Column(name="PAY_TIME")
	private   String  payTime;
	// 
	@Column(name="GOODS_AMOUNT")
	private   java.math.BigDecimal  goodsAmount;
	// 
	@Column(name="PAY_FEE")
	private   java.math.BigDecimal  payFee;
	// 
	@Column(name="SHIPPING_FEE")
	private   java.math.BigDecimal  shippingFee;
	// 
	@Column(name="INSURED_FEE")
	private   java.math.BigDecimal  insuredFee;
	// 
	@Column(name="INVOICE_FEE")
	private   java.math.BigDecimal  invoiceFee;
	// 
	@Column(name="ONLINE_PAID")
	private   java.math.BigDecimal  onlinePaid;
	// 
	@Column(name="OFFLINE_PAID")
	private   java.math.BigDecimal  offlinePaid;
	// 
	@Column(name="BALANCE_PAID")
	private   java.math.BigDecimal  balancePaid;
	// 
	@Column(name="INTEGRAL_FEE")
	private   java.math.BigDecimal  integralFee;
	// 
	@Column(name="INTEGRAL_PAID")
	private   java.math.BigDecimal  integralPaid;
	// 
	@Column(name="COUPONS_SN")
	private   String  couponsSn;
	// 
	@Column(name="COUPONS_PAID")
	private   java.math.BigDecimal  couponsPaid;
	// 
	@Column(name="GCARD_SN")
	private   String  gcardSn;
	// 
	@Column(name="GCARD_PAID")
	private   java.math.BigDecimal  gcardPaid;
	// 
	@Column(name="DISCOUNT_AMOUNT")
	private   java.math.BigDecimal  discountAmount;
	// 
	@Column(name="ORDER_AMOUNT")
	private   java.math.BigDecimal  orderAmount;
	// 
	@Column(name="GIFT_INTEGRAL")
	private   java.math.BigDecimal  giftIntegral;
	// 
	@Column(name="GIFT_COUPONS")
	private   String  giftCoupons;
	// 
	@Column(name="CONFIRM_TIME")
	private   String  confirmTime;
	// 
	@Column(name="EXTENSION_CODE")
	private   String  extensionCode;
	// 
	@Column(name="DELIVERY_NOTE")
	private   String  deliveryNote;
	// 
	@Column(name="INVOICE_TITLE")
	private   String  invoiceTitle;
	// 
	@Column(name="INVOICE_TYPE")
	private   java.math.BigDecimal  invoiceType;
	// 
	@Column(name="INVOICE_CONTENT")
	private   String  invoiceContent;
	// 
	@Column(name="PAY_NOTE")
	private   String  payNote;
	// 
	@Column(name="TO_BUYER")
	private   String  toBuyer;
	// 
	@Column(name="AGENCY_ID")
	private   String  agencyId;
	// 
	@Column(name="SD_ID")
	private   String  sdId;
	// 
	@Column(name="SD_DESC")
	private   String  sdDesc;
	// 
	@Column(name="FAIL_DESC")
	private   String  failDesc;
	// 
	@Column(name="PARENT_ID")
	private   String  parentId;
	// 
	@Column(name="IS_CAN_COMMENT")
	private   String  isCanComment;
	// 
	@Column(name="SOURCE")
	private   String  source;
	// 
	@Column(name="PRINTSTATE")
	private   String  printstate;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="ORDER_REMARK")
	private   String  orderRemark;
	// 
	@Column(name="POSTSCRIPT")
	private   String  postscript;
	// 
	@Column(name="ALTERNATEFIELD1")
	private   String  alternatefield1;
	// 
	@Column(name="ALTERNATEFIELD2")
	private   String  alternatefield2;
	// 
	@Column(name="PROMOTESMONEY")
	private   java.math.BigDecimal  promotesmoney;
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