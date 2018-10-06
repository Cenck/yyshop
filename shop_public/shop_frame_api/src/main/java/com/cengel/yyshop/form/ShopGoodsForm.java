package com.cengel.yyshop.form;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 15:54
 * @Version V1.0
 **/
@Data
public class ShopGoodsForm implements Serializable {

	private Double buyAmount;
	private Double discountAmount;

	/********************|| shopordergoods ||********************/
	private BigDecimal discountPrice;

	/********************|| ShopGoods字段 ||********************/
	private Integer              id;
	// 删除标志 0:未删除 1:已删除
	private Boolean              deleted;
	// ~~~~实体属性
	// 产品id
	// @NotNull(message = "产品id不能为空!")
	private String               productsId;
	private String               goodsNo;
	// 商品名称
	private String               goodsTitle;
	// 商品副名称
	private String               subtitle;
	// 搜索关键词
	private String               seoKeyWords;
	// 售卖地
	private String               saleAddress;
	// 上市地区id
	private String               districtId;
	// 代理商id
	private String               agencyId;
	// 代理商名称
	private String               agencyName;
	// 市场价
	private java.math.BigDecimal marketPrice;
	// 销售价
	private java.math.BigDecimal salePrice;
	// 成本价
	private java.math.BigDecimal costPrice;
	// 分类id
	private String               catId;
	// 分类名称
	private String               catName;
	// 类型id
	private String               typeId;
	// 类型名称
	private String               typeName;
	//
	private String               markId;
	// 品牌id
	private String               brandId;
	// 品牌名称
	private String               brandName;
	//
	private String               goodsSpecValues;
	// 获得经验值
	private java.math.BigDecimal givePoints;
	// 月销量
	private java.math.BigDecimal saleNum;
	// 总销量
	private java.math.BigDecimal totalSaleNum;
	// 总库存
	private java.math.BigDecimal totalStockNum;
	// 售后
	// @NotNull(message = "售后不能为空!")
	private String               afterService;
	// 售后时间
	private java.util.Date       afterServiceTime;
	// 商品开放时间
	private java.util.Date       beginTime;
	// 商品失效时间
	private java.util.Date       endTime;
	// 预售日期
	private java.util.Date       presaletime;
	// 浏览次数
	private Long                 viewCount;
	//
	private Boolean              isEnable;
	//
	private Boolean              isOnSale;
	// 是否是限购商品
	private Boolean              isLimitGoods;
	//
	private Boolean              isReal;
	// 商品展示图片
	private String               defaultImgUrl;
	// 默认展示图片-压缩
	private String               defaultImgThumbUrl;
	//
	private Boolean              isHot;
	//
	private Boolean              isNew;
	// 毛重
	private java.math.BigDecimal grossWeight;
	// 静重
	private java.math.BigDecimal netWeight;
	// 体积
	private java.math.BigDecimal volume;
	//
	// @NotNull(message = "不能为空!")
	private java.util.Date       createTime;

}
