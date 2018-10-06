package com.cengel.yyshop.orderinfo.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：
*/
@Getter
@Setter
@Entity(name = "SHOP_ORDER_TYPE")
public class ShopOrderType extends BaseEntity<Integer> {

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
	@Column(name="ORDER_TYPE_NAME")
	private   String  orderTypeName;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name="ORDER_TYPE_CODE")
	private   String  orderTypeCode;
	// 
	@Column(name="REMARK")
	private   String  remark;
	// 
	@Column(name="OPERATOR")
	private   String  operator;
	// 
	@Column(name="SUB_ORDER_TYPE_NAME")
	private   String  subOrderTypeName;
	// 
	@Column(name="SUB_ORDER_TYPE_CODE")
	private   String  subOrderTypeCode;
	// 
	@Column(name="UNION_TYPE_CODE")
	private   String  unionTypeCode;
	// 
	@Column(name="IS_DEL")
	private   String  isDel;
	// 
	@Column(name="ISOLATE")
	private   String  isolate;
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