package com.cengel.yyshop.member.service;

import com.cengel.yyshop.member.entity.ShopMember;
import com.cengel.hibernate.service.BaseService;

/**
 * 业务层：商城注册会员
 */
public interface ShopMemberService  extends BaseService<ShopMember, Integer>  {

	ShopMember getByLoginName(String username);
}
