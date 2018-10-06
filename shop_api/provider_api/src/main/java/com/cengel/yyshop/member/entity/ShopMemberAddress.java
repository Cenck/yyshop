package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 实体对象：会员收货地址
 */
@Getter
@Setter
@Entity(name = "SHOP_MEMBER_ADDRESS")
public class ShopMemberAddress implements BEntity<Integer> {

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
	@Column(name = "MEMBER_ID")
	private String         memberId;
	// 收件人
	@Column(name = "CONSIGNEE")
	private String         consignee;
	// 收件人邮箱
	@Column(name = "EMAIL")
	private String         email;
	// 区id
	@Column(name = "DIST_ID")
	private Integer        distId;
	// 详细地址(手输)
	@Column(name = "ADDRESS")
	private String         address; //省市区文字
	@Column(name = "ADDRESS_DETAIL")
	private String         addressDetail;//街道和具体地址
	// 邮编
	@Column(name = "ZIPCODE")
	private String         zipcode;
	// 电话
	@Column(name = "TEL")
	private String         tel;
	// 手机号
	@Column(name = "MOBILE")
	private String         mobile;
	// 地标
	@Column(name = "SIGN_BUILDING")
	private String         signBuilding;
	// 最佳送达日期
	@Column(name = "BEST_DATE")
	private java.util.Date bestDate;
	// 送达最佳时间
	@Column(name = "BEST_TIME")
	private String         bestTime;
	// 是否默认
	@Column(name = "IS_DEFAULT")
	private Boolean        isDefault;
	// 支付id
	@Column(name = "PAY_ID")
	private String         payId;
	// 购物id
	@Column(name = "SHIPPING_ID")
	private String         shippingId;
	// 发票抬头
	@Column(name = "INVOICE_TITLE")
	private String         invoiceTitle;
	// 发票内容
	@Column(name = "INVOICE_CONTENT")
	private String         invoiceContent;
	// 发票类型
	@Column(name = "INVOICE_TYPE")
	private String         invoiceType;
	// 发票id
	@Column(name = "INVITE_ID")
	private String         inviteId;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "CREATE_TIME")
	private java.util.Date createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "MODIFIED_TIME")
	private java.util.Date modifiedTime;
	// 
	@Column(name = "CREATE_BY")
	private String         createBy;
	// 
	@Column(name = "MODIFIED_BY")
	private String         modifiedBy;

}