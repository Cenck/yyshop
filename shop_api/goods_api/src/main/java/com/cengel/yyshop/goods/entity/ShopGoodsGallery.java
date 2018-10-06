package com.cengel.yyshop.goods.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商城图片
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_GALLERY")
public class ShopGoodsGallery extends BaseEntity<Integer> {

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
	@Column(name="SRC_ID")
	private   Integer  srcId;
	// 图片url
	// @NotNull(message = "图片url不能为空!")
	@Column(name="IMG_URL")
	private   String  imgUrl;
	// 图片说明
	@Column(name="IMG_DESC")
	private   String  imgDesc;
	// 图片压缩url
	// @NotNull(message = "图片压缩url不能为空!")
	@Column(name="THUMB_URL")
	private   String  thumbUrl;
	// 
	@Column(name="IMG_ORIGINAL")
	private   String  imgOriginal;
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