package com.cengel.yyshop.promotion.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.starbucks.model.entity.VersionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 实体对象：秒杀记录表
 */
@Getter
@Setter
@Entity(name = "SHOP_SECKILL_ORDER")
public class ShopSeckillOrder implements BEntity<Integer>, VersionEntity {

	// ~~~~实体属性
	// 秒杀id
	// @NotNull(message = "秒杀id不能为空!")
	@Column(name = "SECKILL_ID")
	private Integer              seckillId;
	// 用户id
	// @NotNull(message = "用户id不能为空!")
	@Column(name = "MEMBER_ID")
	private Integer              memberId;
	@Column(name = "MEMBER_NAME")
	private String               memberName;
	@Column(name = "ORDER_ID")
	private Integer              orderId;
	@Column(name = "DISCOUNT_PRICE")
	private java.math.BigDecimal discountPrice;
	// 状态标识:-1:无效 0:成功 1:已付款 2:已发货
	// @NotNull(message = "状态标识:-1:无效 0:成功 1:已付款 2:已发货不能为空!")
	@Column(name = "STATE")
	private Integer              state;
	// 是否幸运
	@Column(name = "IS_LUCKY")
	private Boolean              isLucky;
	@Column(name = "COST_TIME")
	private Integer              costTime;
	@Column(name = "BUY_INDEX")
	private Integer              buyIndex;
	// @NotNull(message = "不能为空!")
	@Column(name = "CREATE_TIME")
	private java.util.Date       createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "MODIFIED_TIME")
	private java.util.Date       modifiedTime;
	// 
	@Column(name = "CREATE_BY")
	private String               createBy;
	// 
	@Column(name = "MODIFIED_BY")
	private String               modifiedBy;
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer              id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean              deleted;
	@Version
	@Column(name = "VERSION", columnDefinition = "INT default 0 ", nullable = false)
	private Long                 version;

}