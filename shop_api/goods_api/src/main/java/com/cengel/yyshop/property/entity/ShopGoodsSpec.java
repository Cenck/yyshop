package com.cengel.yyshop.property.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品说明书
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_SPEC")
public class ShopGoodsSpec extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 说明名称
	// @NotNull(message = "说明名称不能为空!")
	@Column(name="SPEC_NAME")
	private   String  specName;
	// 排序
	// @NotNull(message = "排序不能为空!")
	@Column(name="SORT_ORDER")
	private   Integer  sortOrder;
	// 是否过滤
	// @NotNull(message = "是否过滤不能为空!")
	@Column(name="IS_FILTER")
	private   Integer  isFilter;
	// 是否可用
	// @NotNull(message = "是否可用不能为空!")
	@Column(name="IS_ENABLE")
	private   Integer  isEnable;
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