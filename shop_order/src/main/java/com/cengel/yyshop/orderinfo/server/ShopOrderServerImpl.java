package com.cengel.yyshop.orderinfo.server;

import com.cengel.redis.helper.RedisCodeHelper;
import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.starbucks.util.AssertUtil;
import com.cengel.starbucks.core.beans.BeanCopyUtil;
import com.cengel.yyshop.form.ShopGoodsForm;
import com.cengel.yyshop.form.ShopOrderAddressForm;
import com.cengel.yyshop.orderinfo.entity.ShopOrderAddress;
import com.cengel.yyshop.orderinfo.entity.ShopOrderGoods;
import com.cengel.yyshop.orderinfo.entity.ShopOrderInfo;
import com.cengel.yyshop.orderinfo.enums.OrderStateEnum;
import com.cengel.yyshop.orderinfo.service.ShopOrderAddressService;
import com.cengel.yyshop.orderinfo.service.ShopOrderGoodsService;
import com.cengel.yyshop.orderinfo.service.ShopOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;

import static com.cengel.yyshop.constant.ShopSnConstant.OrderSn.ORDER_SN_PREFFIX;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/22 - 15:51
 * @Version V1.0
 **/
@Service
@com.alibaba.dubbo.config.annotation.Service
public class ShopOrderServerImpl implements ShopOrderServer {

	@Resource
	private ShopOrderInfoService    shopOrderInfoService;
	@Resource
	private ShopOrderGoodsService   shopOrderGoodsService;
	@Resource
	private ShopOrderAddressService shopOrderAddressService;
	@Autowired
	private RedisCodeHelper         redisCodeHelper;

	@Override
	public Response doCreateGoodsOrder(ShopGoodsForm goods, ShopOrderAddressForm addrForm, OnlineUser user) {
		UserHolder.setUser(user);
		AssertUtil.notNull(goods, "商品不能为空");

		/********************|| 创建订单信息 ||********************/
		ShopOrderInfo orderInfo = new ShopOrderInfo();
		orderInfo.setOrderSn(ORDER_SN_PREFFIX + redisCodeHelper.getOrderSnSuffix());
		orderInfo.setGoodsAmount(goods.getTotalStockNum());
		if (goods.getBuyAmount() != null) orderInfo.setOrderAmount(new BigDecimal(goods.getBuyAmount()));
		if (goods.getDiscountAmount() != null) orderInfo.setDiscountAmount(new BigDecimal(goods.getDiscountAmount()));
		orderInfo.setUserId(UserHolder.getUser().getId());
		orderInfo.setOrderStatus(OrderStateEnum.INIT.getCode());
		shopOrderInfoService.insert(orderInfo);

		/********************|| 创建商品快照 ||********************/
		ShopOrderGoods orderGoods = BeanCopyUtil.copy(goods, ShopOrderGoods.class);
		orderGoods.setId(null);
		orderGoods.setGoodsId(goods.getId());
		orderGoods.setOrderId(orderInfo.getId());
		shopOrderGoodsService.insert(orderGoods);

		/********************|| 创建订单地址 ||********************/
		ShopOrderAddress address = BeanCopyUtil.copy(addrForm, ShopOrderAddress.class);
		address.setOrderId(orderInfo.getId());
		shopOrderAddressService.insert(address);

		return Response.success().addData(orderInfo.getId());
	}
}
