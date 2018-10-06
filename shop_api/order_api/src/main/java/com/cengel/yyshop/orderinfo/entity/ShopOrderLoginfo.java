package com.cengel.yyshop.orderinfo.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：订单日志
*/
@Getter
@Setter
@Entity(name = "SHOP_ORDER_LOGINFO")
public class ShopOrderLoginfo extends BaseEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 订单号
	// @NotNull(message = "订单号不能为空!")
	@Column(name="ORDER_ID")
	private   String  orderId;
	// 用户id(user/member)
	@Column(name="USER_ID")
	private   String  userId;
	// 是否为管理员
	@Column(name="IS_ADMIN")
	private   String  isAdmin;
	// 订单状态
	@Column(name="ORDER_STATUS")
	private   String  orderStatus;
	// 运输状态
	@Column(name="SHIPPING_STATUS")
	private   String  shippingStatus;
	// 支付状态
	@Column(name="PAY_STATUS")
	private   String  payStatus;
	// 代理商id
	@Column(name="AGENCY_ID")
	private   String  agencyId;
	// 备注
	@Column(name="ACT_NOTE")
	private   String  actNote;
	// 操作员
	@Column(name="OPERATOR")
	private   String  operator;
	// 操作类型
	@Column(name="OPERATORTYPE")
	private   String  operatortype;
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