package com.cengel.yyshop.goods.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_PRODUCTS")
public class ShopGoodsProducts extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 惟一编号
	// @NotNull(message = "惟一编号不能为空!")
	@Column(name="PRODUCTS_NO")
	private   String  productsNo;
	// 产品名称
	// @NotNull(message = "产品名称不能为空!")
	@Column(name="PRODUCTS_NAME")
	private   String  productsName;
	// 
	@Column(name="CAT_ID")
	private   String  catId;
	// 
	@Column(name="TYPE_ID")
	private   String  typeId;
	// 
	@Column(name="BRAND_ID")
	private   String  brandId;
	// 原产地
	@Column(name="YIELDLY_ID")
	private   String  yieldlyId;
	// 原产地
	@Column(name="YIELDLY_ADDR")
	private   String  yieldlyAddr;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="IS_ENABLE")
	private   Boolean  isEnable;
	// 是否需要安装
	@Column(name="IS_INSTALL")
	private   Boolean  isInstall;
	// 服务连接
	@Column(name="SERVICE_URL")
	private   String  serviceUrl;
	// 服务内容
	@Column(name="SERVICE_CONTENT")
	private   String  serviceContent;
	// 产品说明
	@Column(name="PRODUCTS_DESC")
	private   String  productsDesc;
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