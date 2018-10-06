package com.cengel.yyshop.facade.impl;

import com.cengel.redis.annotation.RedisCache;
import com.cengel.redis.helper.RedisSessionHelper;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.app.config.AppServerFactory;
import com.cengel.yyshop.enums.PlatformEnum;
import com.cengel.yyshop.facade.AppMemberLoginFacade;
import com.cengel.yyshop.member.dao.ShopMemberDetailDO;
import com.cengel.yyshop.member.entity.ShopMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static com.cengel.yyshop.constant.ShopRedisKeys.MenuMembers.APP_MEMBER_LOGIN_DETAIL;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 15:27
 * @Version V1.0
 **/
@Slf4j
@Service
public class AppMemberLoginFacadeImpl implements AppMemberLoginFacade {

	@Autowired
	private AppServerFactory   serverFactory;
	@Autowired
	private RedisSessionHelper sessionHelper;

	@Override
	@RedisCache(value = APP_MEMBER_LOGIN_DETAIL, key = "#p0", expire = 15 * 60 * 60) //保存15分钟
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ShopMember member = serverFactory.memberServer.getByLoginName(username);
		ShopMemberDetailDO detailDO = serverFactory.memberServer.getMemberDetail(member.getId());
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setAccount(member.getAccount());
		onlineUser.setId(member.getId());
		onlineUser.setNickName(member.getNickName());
		onlineUser.setRealName(member.getName());
		onlineUser.setPlatform(PlatformEnum.APP.getCode());
		onlineUser.setAddressId(member.getDefaultAddressId());
		onlineUser.setDistId(detailDO.getAddress().getDistId());
		onlineUser.setFunds(detailDO.getFunds().getFunds());
		onlineUser.setMoney(detailDO.getFunds().getMoney());
		onlineUser.setPoints(detailDO.getFunds().getPoints());
		sessionHelper.putUser(onlineUser);
		return new User(member.getAccount(), member.getPassword(), detailDO.getAuthorityList());
	}
}
