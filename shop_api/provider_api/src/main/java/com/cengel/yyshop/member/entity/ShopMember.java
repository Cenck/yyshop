package com.cengel.yyshop.member.entity;

import com.cengel.starbucks.model.entity.BEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * 实体对象：商城注册会员
 */
@Getter
@Setter
@Entity(name = "SHOP_MEMBER")
public class ShopMember implements BEntity<Integer> {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	// 删除标志 0:未删除 1:已删除
	@Column(name = "DELETED", columnDefinition = "0")
	private Boolean deleted;

	// ~~~~实体属性
	// 等级
	@Column(name = "RANK_ID")
	private Integer        rankId;
	// 帐号
	// @NotNull(message = "帐号不能为空!")
	@Column(name = "ACCOUNT")
	private String         account;
	// 昵称
	@Column(name = "NICK_NAME")
	private String         nickName;
	// 推荐人
	@Column(name = "RECOMMENDER")
	private String         recommender;
	// 
	@Column(name = "PASSWORD")
	private String         password;
	// 头像
	@Column(name = "AVATAR")
	private String         avatar;
	// 会员状态
	@Column(name = "STATUS")
	private String         status;
	// 登录次数
	@Column(name = "LOGIN_COUNT")
	private Long           loginCount;
	// 邮箱
	@Column(name = "EMAIL")
	private String         email;
	// 会员手机号
	@Column(name = "PHONE")
	private String         phone;
	// 
	@Column(name = "NAME")
	private String         name;
	// 
	@Column(name = "SEX")
	private String         sex;
	// 
	@Column(name = "REMARK")
	private String         remark;
	// 
	@Column(name = "THUMBNAIL")
	private String         thumbnail;
	// 是否认证
	@Column(name = "VERIFICATION")
	private Boolean        verification;
	// 认证连接
	@Column(name = "VERIFY_URL")
	private String         verifyUrl;
	// 会员认证时间
	@Column(name = "VERIFTIME")
	private java.util.Date veriftime;
	// 
	@Column(name = "IDENTIFY_CODE")
	private String         identifyCode;
	// 
	@Column(name = "VERIFY_TYPE")
	private String         verifyType;
	// 
	@Column(name = "CAPACITY_CODE")
	private String         capacityCode;
	// 
	@Column(name = "CAPACITY_TYPE")
	private String         capacityType;
	// 
	@Column(name = "IDENTITY_CARD")
	private String         identityCard;
	// 
	@Column(name = "MAIL_REGIST_VERIFY_FLAG")
	private String         mailRegistVerifyFlag;
	// 
	@Column(name = "MEDIA_URL")
	private String         mediaUrl;
	// 
	@Column(name = "REFERRAL_CODE")
	private String         referralCode;
	@Column(name = "DEFAULT_ADDRESS_ID")
	private Integer        defaultAddressId;
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

}