package com.cengel.yyshop.form;

import lombok.Data;

import java.io.Serializable;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 16:11
 * @Version V1.0
 **/
@Data
public class ShopOrderAddressForm implements Serializable {

	private Integer id;
	// 删除标志 0:未删除 1:已删除
	private Boolean deleted;

	// ~~~~实体属性
	//
	// @NotNull(message = "不能为空!")
	private Integer orderId;
	//
	private String  consignee;
	//
	private String  email;

	private Integer distId;
	//
	private String  address;
	private String         addressDetail;//街道和具体地址
	//
	private String  zipcode;
	//
	private String  tel;
	//
	private String  mobile;
	//
	private String  signBuilding;
	//
	private String  bestTime;
	//
	private String  bestDate;
	//
	private String  invoiceTitle;
	//
	private String  invoiceContent;
	//
	private String  invoiceType;
}
