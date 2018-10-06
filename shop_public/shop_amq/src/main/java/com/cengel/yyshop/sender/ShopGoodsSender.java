package com.cengel.yyshop.sender;

import com.cengel.mq.annotation.MqPersistSending;
import com.cengel.yyshop.mqe.CreateGoodsOrderMqe;
import com.cengel.yyshop.mqsource.ShopGoodsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.support.MessageBuilder;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/28 - 16:51
 * @Version V1.0
 **/
@EnableBinding(ShopGoodsSource.class)
public class ShopGoodsSender {

	@Autowired
	private ShopGoodsSource shopGoodsSource;

	/**
	 * 发送处理下商品订单异步任务
	 *
	 * @param response {Integer seckId, Double buyAmount, Double discountPrice, Integer memberId,Integer seckOrderId}
	 */
	@MqPersistSending
	public void sendCreateGoodsTaskAsync(CreateGoodsOrderMqe mqe) {
		shopGoodsSource.sendCreateGoodsTaskAsyncOut().send(MessageBuilder.withPayload(mqe).build());
	}

}
