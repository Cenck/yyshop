package com.cengel.yyshop.controller;

import com.cengel.starbucks.model.obj.Response;
import com.cengel.starbucks.model.user.UserHolder;
import com.cengel.yyshop.member.dao.ShopMemberDetailDO;
import com.cengel.yyshop.app.config.AppServerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/24 - 17:20
 * @Version V1.0
 **/
@RestController
@RequestMapping("member")
public class AppMemberController {

	@Resource
	private AppServerFactory serverFactory;

	@RequestMapping("info")
	public Response info() {
		Integer memberId = UserHolder.getId();
		ShopMemberDetailDO detailDO = serverFactory.memberServer.getMemberDetail(memberId);
		return Response.success().addData(detailDO);
	}

}
