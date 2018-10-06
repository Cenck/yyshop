package com.cengel.yyshop.property.entity;

import com.cengel.starbucks.model.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
* 实体对象：商品库存
*/
@Getter
@Setter
@Entity(name = "SHOP_GOODS_STOCK")
public class ShopGoodsStock extends BaseEntity<Integer> {

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
	private   Integer  goodsId;
	// 省
	@Column(name="PROVINCE_ID")
	private   String  provinceId;
	// 
	@Column(name="PROVINCE_NAME")
	private   String  provinceName;
	// 市
	@Column(name="CITY_ID")
	private   String  cityId;
	// 
	@Column(name="CITY_NAME")
	private   String  cityName;
	// 区
	@Column(name="DISTRICT_ID")
	private   Integer  districtId;
	// 
	@Column(name="DISTRICT_NAME")
	private   String  districtName;
	// 库存id
	@Column(name="WAREHOUSE_ID")
	private   String  warehouseId;
	// 实际可用库存
	@Column(name="STOCK_NUM")
	private   java.math.BigDecimal  stockNum;
	// 冻结库存
	@Column(name="FREEZE_NUM")
	private   java.math.BigDecimal  freezeNum;
	// 度量单位
	@Column(name="MEASURE_UNIT")
	private   String  measureUnit;
	// 总库存量(含不可用)
	@Column(name="TOTAL_NUM")
	private   java.math.BigDecimal  totalNum;
	// 已发货库存
	@Column(name="TRANSIT_NUM")
	private   java.math.BigDecimal  transitNum;
	// 运达时间
	@Column(name="ARRIVAL_TIME")
	private   java.util.Date  arrivalTime;
	// 
	@Column(name="FLAG")
	private   String  flag;
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