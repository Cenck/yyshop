package com.cengel.yyshop.goods.service.impl;

import com.cengel.hibernate.context.HibernateUtil;
import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.starbucks.core.beans.BeanCopyUtil;
import com.cengel.starbucks.model.obj.DataGrid;
import com.cengel.starbucks.model.obj.Page;
import com.cengel.starbucks.model.obj.Params;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.starbucks.util.AssertUtil;
import com.cengel.yyshop.common.server.GoodsServerFactory;
import com.cengel.yyshop.form.ShopGoodsForm;
import com.cengel.yyshop.form.ShopOrderAddressForm;
import com.cengel.yyshop.goods.dto.ShopGoodsInfoDto;
import com.cengel.yyshop.goods.entity.ShopGoods;
import com.cengel.yyshop.goods.service.ShopGoodsService;
import com.cengel.yyshop.property.service.ShopGoodsStockService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/8/1 - 19:58
 * @Version V1.0
 **/
@Slf4j
@Service
public class ShopGoodsServiceImpl extends BaseServiceImpl<ShopGoods, Integer> implements ShopGoodsService {

	@Resource
	private GoodsServerFactory    serverFactory;
	@Resource
	private ShopGoodsStockService shopGoodsStockService;

	@Override
	public void saveOrUpdate(ShopGoods shopGoods) {
		AssertUtil.notNull(shopGoods.getGoodsTitle(), "商品名不能为空");
		AssertUtil.notNull(shopGoods.getSubtitle(), "商品副标题不能为空");
		shopGoods.setIsEnable(Boolean.TRUE);
		super.saveOrUpdate(shopGoods);
	}

	@Override
	public List<ShopGoods> listBanner(int len) {
		ShopGoods shopGoods = new ShopGoods();
		Params params = Params.create().addEntity(shopGoods);
		shopGoods.setIsEnable(true);
		shopGoods.setIsHot(true);
		Page page = new Page();
		page.setLimit(len);
		DataGrid dg = this.pageLike(params, page);
		return (List<ShopGoods>) dg.getItems();
	}

	@Override
	public ShopGoodsInfoDto getDto(Integer id) {
		ShopGoods shopGoods = this.get(id);
		return BeanCopyUtil.copy(shopGoods, ShopGoodsInfoDto.class);
	}

	@Override
	public Response doCreateOrder(ShopGoodsForm goodsForm, ShopOrderAddressForm addressForm) {
		AssertUtil.notNull(goodsForm.getBuyAmount(), "购买数量不能为0");

		/********************|| 生成订单 ||********************/
		Response orderRet = serverFactory.shopOrderServer.doCreateGoodsOrder(goodsForm, addressForm, UserHolder.getUser());
		log.info("生成订单成功：" + orderRet.getObj());

		/********************|| 扣减商品库存 ||********************/
		if (goodsForm.getDiscountAmount() == null) goodsForm.setDiscountAmount(0.0);
		Double deductNum = goodsForm.getBuyAmount() - goodsForm.getDiscountAmount();
		shopGoodsStockService.doDeductFreezeStock(goodsForm.getId(), deductNum);
		log.info("sessionId:{}", System.identityHashCode(HibernateUtil.currentSession()));
		return orderRet;
	}

}
