package com.cengel.yyshop.category.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品分类
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_CATEGORY")
public class ShopGoodsCategory extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 分类名称
	// @NotNull(message = "分类名称不能为空!")
	@Column(name="CAT_NAME")
	private   String  catName;
	// 搜索关键字
	@Column(name="SEO_KEYWORDS")
	private   String  seoKeywords;
	// 搜索说明
	@Column(name="SEO_DESC")
	private   String  seoDesc;
	// 父ID
	@Column(name="PARENT_ID")
	private   String  parentId;
	// 父类类型
	@Column(name="TYPE_ID")
	private   String  typeId;
	// 排序
	@Column(name="SORT_ORDER")
	private   Integer  sortOrder;
	// 度量单位
	@Column(name="MEASURE_UNIT")
	private   String  measureUnit;
	// 显示在导航
	@Column(name="SHOW_IN_NAV")
	private   Integer  showInNav;
	// 
	@Column(name="IS_ENABLE")
	private   Integer  isEnable;
	// 分类等级
	@Column(name="CAT_LEVEL")
	private   Integer  catLevel;
	// 分类小图
	@Column(name="CATE_IMG")
	private   String  cateImg;
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