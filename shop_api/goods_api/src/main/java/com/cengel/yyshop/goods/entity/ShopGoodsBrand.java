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
@Entity(name = "SHOP_GOODS_BRAND")
public class ShopGoodsBrand extends BaseEntity<Integer> {

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
	@Column(name="BRAND_NAME")
	private   String  brandName;
	// 
	@Column(name="CAT_ID")
	private   String  catId;
	// 
	@Column(name="BRAND_LOGO")
	private   String  brandLogo;
	// 
	@Column(name="LOGO_THUMB")
	private   String  logoThumb;
	// 
	@Column(name="BRAND_DESC")
	private   String  brandDesc;
	// 
	@Column(name="SITE_URL")
	private   String  siteUrl;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="SORT_ORDER")
	private   java.math.BigDecimal  sortOrder;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="IS_ENABLE")
	private   String  isEnable;
	// 
	@Column(name="SEO_TITLE")
	private   String  seoTitle;
	// 
	@Column(name="SEO_KEYWORDS")
	private   String  seoKeywords;
	// 
	@Column(name="SEO_DESC")
	private   String  seoDesc;
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