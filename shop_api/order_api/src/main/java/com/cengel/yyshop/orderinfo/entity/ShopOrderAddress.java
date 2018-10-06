package com.cengel.yyshop.orderinfo.entity;

import com.cengel.starbucks.model.entity.BEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 实体对象：
 */
@Getter
@Setter
@Entity(name = "SHOP_ORDER_ADDRESS")
public class ShopOrderAddress implements BEntity<Integer> {

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
	private Integer        orderId;
	// 
	@Column(name = "CONSIGNEE")
	private String         consignee;
	// 
	@Column(name = "EMAIL")
	private String         email;
	//
	@Column(name = "DIST_ID")
	private Integer         distId;
	// 
	@Column(name = "ADDRESS")
	private String         address;
	@Column(name = "ADDRESS_DETAIL")
	private String         addressDetail;//街道和具体地址
	// 
	@Column(name = "ZIPCODE")
	private String         zipcode;
	// 
	@Column(name = "TEL")
	private String         tel;
	// 
	@Column(name = "MOBILE")
	private String         mobile;
	// 
	@Column(name = "SIGN_BUILDING")
	private String         signBuilding;
	// 
	@Column(name = "BEST_TIME")
	private String         bestTime;
	// 
	@Column(name = "BEST_DATE")
	private String         bestDate;
	// 
	@Column(name = "INVOICE_TITLE")
	private String         invoiceTitle;
	// 
	@Column(name = "INVOICE_CONTENT")
	private String         invoiceContent;
	// 
	@Column(name = "INVOICE_TYPE")
	private String         invoiceType;
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