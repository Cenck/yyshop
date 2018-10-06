package com.cengel.yyshop.member.enums;

import lombok.Getter;
import lombok.Setter;

public enum MemberAuthorityEnum {

	MEMBER("member","普通会员"),
	VIP("vip","高级会员"),
	SVIP("svip","尊贵白金会员")
	;

	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	private String desc;

	private MemberAuthorityEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static MemberAuthorityEnum getByCode(String code) {
		if (code == null || "" == code) return null;
		MemberAuthorityEnum[] allEnums = values();
		for (MemberAuthorityEnum thisEnum : allEnums) {
			if (thisEnum.code.equals(code)) {
				return thisEnum;
			}
		}
		return null;
	}


}
