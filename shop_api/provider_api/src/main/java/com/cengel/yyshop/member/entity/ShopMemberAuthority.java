package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import com.cengel.yyshop.member.enums.MemberAuthorityEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

/**
 * 实体对象：用户等级分类
 */
@Getter
@Setter
@Entity(name = "SHOP_MEMBER_AUTHORITY")
public class ShopMemberAuthority implements BEntity<Integer>, GrantedAuthority {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;

	// ~~~~实体属性
	// 权限码
	// @NotNull(message = "权限码不能为空!")
	@Column(name = "AUTHORITY")
	private String         authority;
	// 权限名称
	// @NotNull(message = "权限名称不能为空!")
	@Column(name = "AUTHORITY_NAME")
	private String         authorityName;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "CREATE_TIME")
	private java.util.Date createTime;
	// 
	// @NotNull(message = "不能为空!")
	@Column(name = "MODIFIED_TIME")
	private java.util.Date modifiedTime;
	// 
	@Column(name = "CREATE_BY")
	private String         createBy;
	// 
	@Column(name = "MODIFIED_BY")
	private String         modifiedBy;

	public static ShopMemberAuthority getByEnum(MemberAuthorityEnum authorityEnum) {
		ShopMemberAuthority dto = new ShopMemberAuthority();
		dto.setAuthority(authorityEnum.getCode());
		dto.setAuthority(authorityEnum.getDesc());
		return dto;
	}
}