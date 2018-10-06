package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：用户等级分类
*/
@Getter
@Setter
@Entity(name = "SHOP_MEMBER_RANK")
public class ShopMemberRank implements BEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 等级名称
	// @NotNull(message = "等级名称不能为空!")
	@Column(name="RANK_NAME")
	private   String  rankName;
	// 等级图标
	@Column(name="RANK_PIC")
	private   String  rankPic;
	// 等级类型
	@Column(name="RANK_TYPE")
	private   String  rankType;
	// 经验点
	@Column(name="POINTS")
	private   java.math.BigDecimal  points;
	// 
	@Column(name="IS_DEFAULT")
	private   Boolean  isDefault;
	// 
	@Column(name="RANK_STATUS")
	private   String  rankStatus;
	// 折扣
	@Column(name="DISCOUNT")
	private   java.math.BigDecimal  discount;
	// 
	@Column(name="THUMBNAIL")
	private   String  thumbnail;
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