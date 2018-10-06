package com.cengel.yyshop.promotion.biz;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;

import java.util.Date;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/27 - 18:59
 * @Version V1.0
 **/
public interface ShopSeckillBuilderBiz {

	/***
	 * 功能描述: 准备，数据置0，创建定时任务
	 * @author: zhz
	 * @param:
	 * @date: 2018/9/27 - 19:01
	 * @return:
	 */
	Response doPrepare(Integer seckId,long totalNum, Date begDate,Date endDate);


	/**
	 * 创建秒杀订单
	 * @param seckId
	 * @param buyNum
	 * @return
	 */
	Response doCreateOrder(Integer seckId, Double buyNum);

	/**
	 * 秒杀结束事件
	 * @param seckId
	 * @return
	 */
	Response doFinish(Integer seckId);

}
