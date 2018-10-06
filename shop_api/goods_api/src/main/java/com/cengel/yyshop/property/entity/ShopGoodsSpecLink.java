package com.cengel.yyshop.property.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品说明Link
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_SPEC_LINK")
public class ShopGoodsSpecLink extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 商品ID
	// @NotNull(message = "商品ID不能为空!")
	@Column(name="GOODS_ID")
	private   String  goodsId;
	// 产品id
	// @NotNull(message = "产品id不能为空!")
	@Column(name="PRODUCT_ID")
	private   String  productId;
	// 说明id
	// @NotNull(message = "说明id不能为空!")
	@Column(name="SPEC_ID")
	private   String  specId;
	// 说明值id
	// @NotNull(message = "说明值id不能为空!")
	@Column(name="SPEC_VAL_ID")
	private   String  specValId;
	// 说明内容
	@Column(name="SPEC_VALUE")
	private   String  specValue;
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