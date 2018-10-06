package com.cengel.yyshop.mq;

import com.cengel.hibernate.dao.BaseDao;
import com.cengel.mq.annotation.MqPersistListening;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.goods.server.ShopGoodsServer;
import com.cengel.yyshop.member.server.ShopMemberServer;
import com.cengel.yyshop.mqe.CreateGoodsOrderMqe;
import com.cengel.yyshop.mqsource.ShopGoodsSource;
import com.cengel.yyshop.promotion.entity.ShopSeckillOrder;
import com.cengel.yyshop.promotion.enums.SeckillOrderStateEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/28 - 16:53
 * @Version V1.0
 **/
@Slf4j
@EnableBinding(ShopGoodsSource.class)
public class ShopGoodsReceiver {

	@Autowired
	private ShopMemberServer shopMemberServer;
	@Autowired
	private ShopGoodsServer  goodsServer;
	@Autowired
	private BaseDao          baseDao;

	/**
	 * 发送处理下商品订单异步任务
	 *
	 * @param orderMqe {Integer seckId, Double buyAmount, Double discountPrice, Integer memberId,Integer seckOrderId}
	 */
	@StreamListener(ShopGoodsSource.CREATE_GOODS_TASK_ASYNC_IN)
	@MqPersistListening
	public void CREATE_GOODS_TASK_ASYNC_IN(CreateGoodsOrderMqe orderMqe) {
		Integer seckId = orderMqe.getSeckId();
		Double buyAmount = orderMqe.getBuyAmount().doubleValue();
		Double discountPrice = orderMqe.getDiscountPrice().doubleValue();
		Integer memberId = orderMqe.getMemberId();
		Integer seckOrderId = orderMqe.getSeckOrderId();
		log.info("ShopGoodsSource: 发送处理下商品订单异步任务{}", orderMqe);
		UserHolder.setUser(shopMemberServer.getOnlineMemberById(memberId));
		goodsServer.doCreateGoodsOrder(seckId, buyAmount, discountPrice, UserHolder.getUser());
		ShopSeckillOrder order = baseDao.get(seckOrderId, ShopSeckillOrder.class);
		order.setState(SeckillOrderStateEnum.CREATED.getState());
		baseDao.update(order);
	}
}
