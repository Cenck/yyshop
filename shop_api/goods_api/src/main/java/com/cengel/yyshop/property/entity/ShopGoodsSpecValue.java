package com.cengel.yyshop.property.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：说明值
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_SPEC_VALUE")
public class ShopGoodsSpecValue extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 说明id
	// @NotNull(message = "说明id不能为空!")
	@Column(name="SPEC_ID")
	private   String  specId;
	// 说明内容
	// @NotNull(message = "说明内容不能为空!")
	@Column(name="SPEC_VALUE")
	private   String  specValue;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="SORT_ORDER")
	private   Integer  sortOrder;
	// logo
	@Column(name="SPEC_LOGO")
	private   String  specLogo;
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