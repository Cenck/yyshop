package com.cengel.yyshop.goods.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品关联
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_LINK")
public class ShopGoodsLink extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 商品id
	// @NotNull(message = "商品id不能为空!")
	@Column(name="GOODS_ID")
	private   String  goodsId;
	// 关键商品id
	// @NotNull(message = "关键商品id不能为空!")
	@Column(name="LINK_GOODS_ID")
	private   String  linkGoodsId;
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