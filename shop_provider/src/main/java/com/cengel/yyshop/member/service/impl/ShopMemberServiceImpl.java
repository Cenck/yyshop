package com.cengel.yyshop.member.service.impl;

import com.cengel.hibernate.service.BaseServiceImpl;
import com.cengel.yyshop.member.entity.ShopMember;
import com.cengel.yyshop.member.service.ShopMemberService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 业务层：商城注册会员
 */
@Service
public class ShopMemberServiceImpl extends BaseServiceImpl<ShopMember, Integer> implements ShopMemberService {

	@Override
	public ShopMember getByLoginName(String account) {
		ShopMember example = new ShopMember();
		example.setDeleted(false);
		example.setAccount(account);
		List<ShopMember> list = find(example);
		if (CollectionUtils.isEmpty(list)) {
			throw new RuntimeException("未找到用户" + account);
		}
		if (list.size() > 1) throw new RuntimeException("错误：找到多个用户：" + account);
		return list.get(0);
	}
}
