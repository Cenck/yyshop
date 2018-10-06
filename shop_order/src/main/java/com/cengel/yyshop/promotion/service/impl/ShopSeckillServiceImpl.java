package com.cengel.yyshop.promotion.service.impl;

import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.starbucks.exception.BusinessException;
import com.cengel.yyshop.promotion.entity.ShopSeckill;
import com.cengel.yyshop.promotion.service.ShopSeckillService;
import com.cengel.yyshop.promotion.vo.ShopSeckillGoodsVo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 业务层：商品秒杀
 */
@Service
public class ShopSeckillServiceImpl extends BaseServiceImpl<ShopSeckill, Integer> implements ShopSeckillService {

	@Override
	public ShopSeckillGoodsVo getGoodsVo(int id) {
		return getBaseDao().get(id, ShopSeckillGoodsVo.class);
	}

	@Override
	public ShopSeckill doCheckAndGet(Integer id, Double buyNum) {
		ShopSeckill ret;
		if (id == null || (ret = get(id)) == null) throw new BusinessException("秒杀订单不存在:" + id);
		Date today = new Date();
		if (today.before(ret.getStartTime())) {
			throw new BusinessException("秒杀还未开始:" + id);
		}
		if (today.after(ret.getEndTime())) {
			throw new BusinessException("很遗憾，秒杀已结束。看看其他商品吧");
		}
		BigDecimal buyAmount = new BigDecimal(buyNum);
		if (ret.getSeckNum().compareTo(buyAmount) < 1) {
			throw new BusinessException("秒杀商品：" + ret.getSkName() + "库存不足");
		}
		return ret;
	}
}
