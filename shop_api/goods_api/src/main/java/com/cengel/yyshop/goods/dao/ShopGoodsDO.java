package com.cengel.yyshop.goods.dao;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.yyshop.goods.entity.ShopGoodsBrand;
import com.cengel.yyshop.goods.entity.ShopGoodsProducts;
import lombok.Data;

import javax.persistence.*;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 13:47
 * @Version V1.0
 **/
@Data
@Entity(name = "SHOP_GOODS")
public class ShopGoodsDO implements BEntity<Integer> {

	@ManyToOne(targetEntity = ShopGoodsProducts.class)
	@JoinColumn(name = "PRODUCTS_ID", insertable = false, updatable = false)
	private ShopGoodsProducts product;

	@JoinColumn(name = "BRAND_ID", insertable = false, updatable = false)
	@ManyToOne(targetEntity = ShopGoodsBrand.class)
	private ShopGoodsBrand brand;

	/********************||  ||********************/
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;

	// ~~~~实体属性
	// 产品id
	// @NotNull(message = "产品id不能为空!")
	@Column(name = "PRODUCTS_ID")
	private String productsId;

	// 商品编号
	// @NotNull(message = "商品编号不能为空!")
	@Column(name = "GOODS_NO")
	private String               goodsNo;
	// 商品名称
	@Column(name = "GOODS_TITLE")
	private String               goodsTitle;
	// 商品副名称
	@Column(name = "SUBTITLE")
	private String               subtitle;
	// 搜索关键词
	@Column(name = "SEO_KEY_WORDS")
	private String               seoKeyWords;
	// 售卖地
	@Column(name = "SALE_ADDRESS")
	private String               saleAddress;
	// 上市地区id
	@Column(name = "DISTRICT_ID")
	private String               districtId;
	// 代理商id
	@Column(name = "AGENCY_ID")
	private String               agencyId;
	// 代理商名称
	@Column(name = "AGENCY_NAME")
	private String               agencyName;
	// 市场价
	@Column(name = "MARKET_PRICE")
	private java.math.BigDecimal marketPrice;
	// 销售价
	@Column(name = "SALE_PRICE")
	private java.math.BigDecimal salePrice;
	// 成本价
	@Column(name = "COST_PRICE")
	private java.math.BigDecimal costPrice;
	// 分类id
	@Column(name = "CAT_ID")
	private String               catId;
	// 分类名称
	@Column(name = "CAT_NAME")
	private String               catName;
	// 类型id
	@Column(name = "TYPE_ID")
	private String               typeId;
	// 类型名称
	@Column(name = "TYPE_NAME")
	private String               typeName;
	//
	@Column(name = "MARK_ID")
	private String               markId;
	// 品牌id
	@Column(name = "BRAND_ID")
	private String               brandId;
	// 品牌名称
	@Column(name = "BRAND_NAME")
	private String               brandName;

	//
	@Column(name = "GOODS_SPEC_VALUES")
	private String               goodsSpecValues;
	// 获得经验值
	@Column(name = "GIVE_POINTS")
	private java.math.BigDecimal givePoints;
	// 月销量
	@Column(name = "SALE_NUM")
	private java.math.BigDecimal saleNum;
	// 总销量
	@Column(name = "TOTAL_SALE_NUM")
	private java.math.BigDecimal totalSaleNum;
	// 总库存
	@Column(name = "TOTAL_STOCK_NUM")
	private java.math.BigDecimal totalStockNum;
	// 售后
	// @NotNull(message = "售后不能为空!")
	@Column(name = "AFTER_SERVICE")
	private String               afterService;
	// 售后时间
	@Column(name = "AFTER_SERVICE_TIME")
	private java.util.Date       afterServiceTime;
	// 商品开放时间
	@Column(name = "BEGIN_TIME")
	private java.util.Date       beginTime;
	// 商品失效时间
	@Column(name = "END_TIME")
	private java.util.Date       endTime;
	// 预售日期
	@Column(name = "PRESALETIME")
	private java.util.Date       presaletime;
	// 浏览次数
	@Column(name = "VIEW_COUNT")
	private Long                 viewCount;
	//
	@Column(name = "IS_ENABLE")
	private Boolean              isEnable;
	//
	@Column(name = "IS_ON_SALE")
	private Boolean              isOnSale;
	// 是否是限购商品
	@Column(name = "IS_LIMIT_GOODS")
	private Boolean              isLimitGoods;
	//
	@Column(name = "IS_REAL")
	private Boolean              isReal;
	// 商品展示图片
	@Column(name = "DEFAULT_IMG_URL")
	private String               defaultImgUrl;
	// 默认展示图片-压缩
	@Column(name = "DEFAULT_IMG_THUMB_URL")
	private String               defaultImgThumbUrl;
	//
	@Column(name = "IS_HOT")
	private Boolean              isHot;
	//
	@Column(name = "IS_NEW")
	private Boolean              isNew;
	// 毛重
	@Column(name = "GROSS_WEIGHT")
	private java.math.BigDecimal grossWeight;
	// 静重
	@Column(name = "NET_WEIGHT")
	private java.math.BigDecimal netWeight;
	// 体积
	@Column(name = "VOLUME")
	private java.math.BigDecimal volume;
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

}
