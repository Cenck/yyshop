package com.cengel.yyshop.mq;

import com.cengel.yyshop.goods.entity.ShopGoods;
import com.cengel.yyshop.mqsource.ShopSeckillSource;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.service.ShopSeckillService;
import com.cengel.yyshop.service.GoodsCacheService;
import com.cengel.yyshop.service.SeckillCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 20:24
 * @Version V1.0
 **/
@Slf4j
@Component
@EnableBinding(ShopSeckillSource.class)
public class ShopSeckReceiver {

	@Autowired
	private GoodsCacheService   goodsCacheService;
	@Autowired
	private SeckillCacheService seckillCacheService;
	@Autowired
	private ShopSeckillService  shopSeckillService;

	/**
	 * 秒杀开始前 缓存所有
	 */
	@StreamListener(ShopSeckillSource.SECK_PREPRARE_IN)
	public void onForPrepare(Integer seckId) {
		log.info("ShopSeckillSource: 执行了秒杀{}前的预处理",seckId);
		ShopSeckill shopSeckill = shopSeckillService.get(seckId);
		ShopGoods shopGoods = shopSeckillService.getBaseDao().get(shopSeckill.getGoodsId(), ShopGoods.class);
		goodsCacheService.set(shopGoods.getId(), shopGoods);
		long time = shopSeckill.getStartTime().getTime() - shopSeckill.getEndTime().getTime();
		seckillCacheService.cacheSeckCount(seckId, time);
		seckillCacheService.set(seckId,shopSeckill);
	}

}
