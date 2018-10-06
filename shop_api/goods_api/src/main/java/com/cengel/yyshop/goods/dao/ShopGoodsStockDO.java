package com.cengel.yyshop.goods.dao;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.yyshop.property.entity.ShopGoodsStock;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 19:25
 * @Version V1.0
 **/
@Data
@Entity(name = "SHOP_GOODS")
public class ShopGoodsStockDO implements BEntity<Integer> {


	// 总库存
	@Column(name = "TOTAL_STOCK_NUM")
	private java.math.BigDecimal totalStockNum;

	@OneToMany(targetEntity = ShopGoodsStock.class,fetch = FetchType.EAGER)
	@JoinColumn(name = "GOODS_ID" ,updatable = false,insertable = false)
	private List<ShopGoodsStock> stocks;


	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//
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

	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;


}
