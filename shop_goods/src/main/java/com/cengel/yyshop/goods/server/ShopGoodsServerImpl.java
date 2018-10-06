package com.cengel.yyshop.goods.server;

import com.cengel.hibernate.context.HibernateUtil;
import com.cengel.starbucks.core.beans.BeanCopyUtil;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.common.server.GoodsServerFactory;
import com.cengel.yyshop.form.ShopGoodsForm;
import com.cengel.yyshop.form.ShopOrderAddressForm;
import com.cengel.yyshop.goods.dao.ShopGoodsDO;
import com.cengel.yyshop.goods.entity.ShopGoods;
import com.cengel.yyshop.goods.service.ShopGoodsService;
import com.cengel.yyshop.member.entity.ShopMemberAddress;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 13:56
 * @Version V1.0
 **/
@Slf4j
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopGoodsServerImpl implements ShopGoodsServer {

	@Autowired
	private ShopGoodsService   shopGoodsService;
	@Autowired
	private GoodsServerFactory serverFactory;

	@Override
	public ShopGoodsDO getGoodsDetail(Integer goodsId) {
		return shopGoodsService.getBaseDao().get(goodsId, ShopGoodsDO.class);
	}

	@Override
	@Transactional
	public Response doCreateGoodsOrder(Integer goodsId, Double buyAmount, Double discountPrice, OnlineUser user) {
		ShopGoods goods = shopGoodsService.get(goodsId);
		log.info("sessionId:{}", System.identityHashCode(HibernateUtil.currentSession()));
		ShopGoodsForm goodsForm = BeanCopyUtil.copy(goods, ShopGoodsForm.class);
		if (discountPrice != null) goodsForm.setDiscountPrice(new BigDecimal(discountPrice));
		goodsForm.setBuyAmount(buyAmount);
		ShopMemberAddress memberAddress = shopGoodsService.getBaseDao().get(user.getAddressId(),ShopMemberAddress.class);
		ShopOrderAddressForm addressForm = BeanCopyUtil.copy(memberAddress, ShopOrderAddressForm.class);
		return shopGoodsService.doCreateOrder(goodsForm, addressForm);
	}
}
