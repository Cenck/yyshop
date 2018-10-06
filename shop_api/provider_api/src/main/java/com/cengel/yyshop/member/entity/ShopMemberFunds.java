package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：会员资金帐户
*/
@Getter
@Setter
@Entity(name = "SHOP_MEMBER_FUNDS")
public class ShopMemberFunds implements BEntity<Integer> {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    // 删除标志 0:未删除 1:已删除
    @Column(name="DELETED",columnDefinition = "0")
    private   Boolean  deleted;

    // ~~~~实体属性
	// 经验点
	@Column(name="POINTS")
	private   java.math.BigDecimal  points;
	// 积分余额
	@Column(name="FUNDS")
	private   java.math.BigDecimal  funds;
	// 冻结资金
	@Column(name="FROZEN_FUNDS")
	private   java.math.BigDecimal  frozenFunds;
	// 余额
	@Column(name="MONEY")
	private   java.math.BigDecimal  money;
	// 冻结资金
	@Column(name="FROZEN_MONEY")
	private   java.math.BigDecimal  frozenMoney;
	// 支付密码
	@Column(name="PAY_PASSWORD")
	private   String  payPassword;
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