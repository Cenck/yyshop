package com.cengel.yyshop.category.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品类型明细
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_TYPE_SPEC")
public class ShopGoodsTypeSpec extends BaseEntity<Integer> {

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
	@Column(name="TYPE_ID")
	private   String  typeId;
	// 
	@Column(name="SORT_ORDER")
	private   Integer  sortOrder;
	// 
	@Column(name="IS_ENABLE")
	private   Integer  isEnable;
	// 
	@Column(name="IS_FILTER")
	private   Integer  isFilter;
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