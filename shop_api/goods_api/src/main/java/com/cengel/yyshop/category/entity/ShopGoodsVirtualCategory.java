package com.cengel.yyshop.category.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_VIRTUAL_CATEGORY")
public class ShopGoodsVirtualCategory extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 
	@Column(name="VIRTUAL_NAME")
	private   String  virtualName;
	// 
	@Column(name="SORT_ORDER")
	private   java.math.BigDecimal  sortOrder;
	// 
	@Column(name="IS_ENABLE")
	private   String  isEnable;
	// 
	@Column(name="TYPE_ID")
	private   String  typeId;
	// 
	@Column(name="MIN_PRICE")
	private   java.math.BigDecimal  minPrice;
	// 
	@Column(name="MAX_PRICE")
	private   java.math.BigDecimal  maxPrice;
	// 
	@Column(name="CAT_ID")
	private   String  catId;
	// 
	@Column(name="KEYWORD")
	private   String  keyword;
	// 
	@Column(name="BRAND_ID")
	private   String  brandId;
	// 
	@Column(name="MARK_ID")
	private   String  markId;
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