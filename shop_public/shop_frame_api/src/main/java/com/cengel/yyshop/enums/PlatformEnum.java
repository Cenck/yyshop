package com.cengel.yyshop.enums;

public enum PlatformEnum {

	MGR("mgr", "管理平台"),
	APP("app", "手机商城");

	private String code;

	private String desc;

	private PlatformEnum(String code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public static PlatformEnum getByCode(String code) {
		if (code == null || "" == code) return null;
		PlatformEnum[] allEnums = values();
		for (PlatformEnum thisEnum : allEnums) {
			if (thisEnum.code.equals(code)) {
				return thisEnum;
			}
		}
		return null;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
