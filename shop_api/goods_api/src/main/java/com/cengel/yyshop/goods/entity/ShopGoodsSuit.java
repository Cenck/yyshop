package com.cengel.yyshop.goods.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品套餐
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_SUIT")
public class ShopGoodsSuit extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 套餐名称
	// @NotNull(message = "套餐名称不能为空!")
	@Column(name="SUIT_NAME")
	private   String  suitName;
	// 折扣金额
	@Column(name="DISCOUNT_PRICE")
	private   java.math.BigDecimal  discountPrice;
	// 套餐说明
	@Column(name="REMARK")
	private   String  remark;
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