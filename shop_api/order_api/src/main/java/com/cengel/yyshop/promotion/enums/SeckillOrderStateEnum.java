package com.cengel.yyshop.promotion.enums;

import lombok.Getter;
import lombok.Setter;

public enum SeckillOrderStateEnum {

	QUEUED(1,"请求入队"),
	CREATED(2,"创建订单"),
	;

	@Getter
	@Setter
	private Integer state;
	@Getter
	@Setter
	private String  desc;

	private SeckillOrderStateEnum(Integer state, String desc) {
		this.state = state;
		this.desc = desc;
	}

	public static SeckillOrderStateEnum getByCode(Integer code) {
		if (code == null) return null;
		SeckillOrderStateEnum[] allEnums = values();
		for (SeckillOrderStateEnum thisEnum : allEnums) {
			if (thisEnum.state.equals(code)) {
				return thisEnum;
			}
		}
		return null;
	}

}
