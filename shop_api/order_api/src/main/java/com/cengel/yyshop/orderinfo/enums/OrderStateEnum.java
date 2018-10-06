package com.cengel.yyshop.orderinfo.enums;

import lombok.Getter;
import lombok.Setter;

public enum OrderStateEnum {

	INIT("init","创建"),
	CANCEL("cancel","取消"),
	PAYED("payed","已支付"),
	FINISH("finish","已完成");

	@Getter
	@Setter
	private String code;
	@Getter
	@Setter
	private String desc;

		private OrderStateEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static OrderStateEnum getByCode(String code) {
		if (code == null || "" == code) return null;
		OrderStateEnum[] allEnums = values();
		for (OrderStateEnum thisEnum : allEnums) {
			if (thisEnum.code.equals(code)) {
				return thisEnum;
			}
		}
		return null;
	}

}
