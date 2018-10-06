package com.cengel.yyshop.test;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.yyshop.test.facade.impl.TestRedisFacadeImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/26 - 9:22
 * @Version V1.0
 **/
@Slf4j
@RestController
@RequestMapping("/test/redis")
public class TestRedisCache {

	@Autowired
	private TestRedisFacadeImpl testRedisFacade;

	@RequestMapping
	public Response index(){
		return Response.success().addData(testRedisFacade.testGoodsToRedis(1));
	}
}
