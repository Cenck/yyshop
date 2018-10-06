package com.cengel.yyshop.member.server;

import com.cengel.starbucks.model.user.OnlineUser;
import com.cengel.yyshop.member.dao.ShopMemberDetailDO;
import com.cengel.yyshop.member.entity.ShopMember;
import com.cengel.yyshop.member.entity.ShopMemberAddress;

public interface ShopMemberServer {
	//根据userName获取Member
	ShopMember getByLoginName(String username);

	ShopMemberDetailDO getMemberDetail(Integer memberId);

	ShopMemberAddress getMemberAddress(Integer memberAddressId);

	OnlineUser getOnlineMemberById(Integer memberId);

}
