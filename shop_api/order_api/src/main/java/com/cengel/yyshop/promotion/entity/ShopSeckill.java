package com.cengel.yyshop.promotion.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.starbucks.model.entity.VersionEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * 实体对象：商品秒杀
 */
@Getter
@Setter
@Entity(name = "SHOP_SECKILL")
public class ShopSeckill implements BEntity<Integer>, VersionEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;

	// ~~~~实体属性
	// 商品id
	// @NotNull(message = "商品id不能为空!")
	@Column(name = "GOODS_ID")
	private Integer        goodsId;
	// 区域id
	@Column(name = "DISTRICT_ID")
	private String         districtId;
	// 秒杀名称
	@Column(name = "SK_NAME")
	private String         skName;
	// 
	@Column(name = "FLAG")
	private String         flag;
	// 秒杀状态
	@Column(name = "SECK_STATUS")
	private String         seckStatus;
	// 秒杀数量
	@Column(name = "SECK_NUM")
	private BigDecimal     seckNum;
	// 秒杀开始时间
	// @NotNull(message = "秒杀开始时间不能为空!")
	@Column(name = "START_TIME")
	private java.util.Date startTime;
	// 秒杀结束时间
	// @NotNull(message = "秒杀结束时间不能为空!")
	@Column(name = "END_TIME")
	private java.util.Date endTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "CREATE_TIME")
	private java.util.Date createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "MODIFIED_TIME")
	private java.util.Date modifiedTime;
	// 
	@Column(name = "CREATE_BY")
	private String         createBy;
	// 
	@Column(name = "MODIFIED_BY")
	private String         modifiedBy;

	@Column(name = "VERSION", columnDefinition = "INT default 0 ", nullable = false)
	@Version
	private Long           version;

}