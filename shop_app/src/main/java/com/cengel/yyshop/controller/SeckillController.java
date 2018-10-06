package com.cengel.yyshop.controller;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.starbucks.util.DateUtil;
import com.cengel.starbucks.util.RandomUtil;
import com.cengel.yyshop.promotion.server.ShopSeckillServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Title:
 * @Description: thor zhz
 * @Time 2018/9/21 - 19:54
 * @Version V1.0
 **/
@Slf4j
@RestController
@RequestMapping("seckill")
public class SeckillController {

	@Autowired
	private ShopSeckillServer shopSeckillServer;

	@RequestMapping("/test/getOne")
	public Response getOne() {
		return Response.success("随机一个订单").addData(shopSeckillServer.getOne());
	}

	@RequestMapping("/test/reset")
	public Response reset(Integer seckId) {
		return shopSeckillServer.doPrepare(seckId,100,new Date(), DateUtil.tomorrow());
	}

	@RequestMapping("start")
	public Response start(Integer seckId, Double buAmount) {
		if (UserHolder.getUser() == null) {
			log.warn("当前request未登录");
			renderOnlineUserById(1);
		}
		if (buAmount == null || buAmount == 0.0) buAmount = 1.0;
		if (seckId == null || seckId < 1) seckId = 1;
		return shopSeckillServer.doCreateOrder(seckId, buAmount, UserHolder.getUser());
	}

	@RequestMapping("/test/thread")
	public Response thread(Integer num, Integer seckId, Double buAmount) {
		Assert.notNull(num, "线程数量不能为空");
		ExecutorService executors = Executors.newFixedThreadPool(num);
		for (int i = 0; i < num; i++) {
			final int index = i;
			executors.submit(() -> {
				renderOnlineUserById(index);
				Response response = start(seckId, buAmount);
				log.info("线程{},执行完毕,花费：{}", index, response.getData().get("costTime"));
			});
		}
		try {
			executors.shutdown();
			executors.awaitTermination(20, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return Response.success("启动成功");
	}

	private OnlineUser renderOnlineUserById(int index) {
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setId(index);
		onlineUser.setAddressId(1);
		onlineUser.setAccount("random_" + index);
		onlineUser.setNickName(RandomUtil.getCnName(3));
		UserHolder.setUser(onlineUser);
		return onlineUser;
	}


}
