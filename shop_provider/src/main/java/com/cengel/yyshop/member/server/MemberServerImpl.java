package com.cengel.yyshop.member.server;

import com.alibaba.dubbo.config.annotation.Service;
import com.cengel.redis.helper.RedisSessionHelper;
import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.enums.PlatformEnum;
import com.cengel.yyshop.member.dao.ShopMemberDetailDO;
import com.cengel.yyshop.member.entity.ShopMember;
import com.cengel.yyshop.member.entity.ShopMemberAddress;
import com.cengel.yyshop.member.service.ShopMemberAddressService;
import com.cengel.yyshop.member.service.ShopMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Title:
 * @Description:
 * @Author zhz
 * @Time 2018/9/21 - 15:30
 * @Version V1.0
 **/
@Service
@Component("MemberServerImpl")
public class MemberServerImpl implements ShopMemberServer {

	@Autowired
	private ShopMemberService        shopMemberService;
	@Autowired
	private ShopMemberAddressService shopMemberAddressService;
	@Autowired
	private RedisSessionHelper       sessionHelper;

	@Override
	public ShopMember getByLoginName(String username) {
		return shopMemberService.getByLoginName(username);
	}

	@Override
	public ShopMemberDetailDO getMemberDetail(Integer userId) {
		return shopMemberService.getBaseDao().get(userId, ShopMemberDetailDO.class);
	}

	@Override
	public ShopMemberAddress getMemberAddress(Integer addressId) {
		return shopMemberAddressService.get(addressId);
	}

	@Override
	public OnlineUser getOnlineMemberById(Integer memberId) {
		ShopMemberDetailDO detailDO = this.getMemberDetail(memberId);
		OnlineUser onlineUser = new OnlineUser();
		onlineUser.setAccount(detailDO.getAccount());
		onlineUser.setId(detailDO.getId());
		onlineUser.setNickName(detailDO.getNickName());
		onlineUser.setRealName(detailDO.getName());
		onlineUser.setPlatform(PlatformEnum.APP.getCode());
		onlineUser.setAddressId(detailDO.getDefaultAddressId());
		onlineUser.setDistId(detailDO.getAddress().getDistId());
		onlineUser.setFunds(detailDO.getFunds().getFunds());
		onlineUser.setMoney(detailDO.getFunds().getMoney());
		onlineUser.setPoints(detailDO.getFunds().getPoints());
		sessionHelper.putUser(onlineUser);
		return onlineUser;
	}

}
