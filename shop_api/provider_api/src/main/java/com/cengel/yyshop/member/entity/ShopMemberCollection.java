package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：用户收藏
*/
@Getter
@Setter
@Entity(name = "SHOP_MEMBER_COLLECTION")
public class ShopMemberCollection implements BEntity<Integer> {

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
	// 商品url
	@Column(name="GOODS_URL")
	private   String  goodsUrl;
	// 收藏日期
	// @NotNull(message = "收藏日期不能为空!")
	@Column(name="COLLECT_DATE")
	private   java.util.Date  collectDate;
	// 
	@Column(name="SALE_PRICE")
	private   java.math.BigDecimal  salePrice;
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