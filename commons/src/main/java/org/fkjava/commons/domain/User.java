package org.fkjava.commons.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "wx_user")
public class User {

	public static enum Status {
		/**
		 * 已经关注
		 */
		IS_SUBSCRIBED,
		/**
		 * 已经取消关注
		 */
		IS_UNSUBSCRIBED;
	}

	@Id
	@GenericGenerator(name = "uuid2", strategy = "uuid2") // 使用Hibernate的UUID2算法生成主键
	@GeneratedValue(generator = "uuid2") // 指定使用的主键生成器
	@Column(length = 36)
	private String id;
	@Enumerated(EnumType.STRING)
	private Status status;
	/** 用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。 */
	@Transient // 不要保存到数据库
	private String subscribe;
	/** 用户的标识，对当前公众号唯一 */
	@JsonProperty("openid") // 指定微信公众号返回的字段名称
	private String openId;
	/** 用户的昵称 */
	@JsonProperty("nickname")
	private String nickName;
	/** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知 */
	private String sex;
	/** 用户所在城市 */
	private String city;
	/** 用户所在国家 */
	private String country;
	/** 用户所在省份 */
	private String province;
	/** 用户的语言，简体中文为zh_CN */
	private String language;
	/**
	 * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
	 */
	@JsonProperty("headimgurl")
	@Column(length = 1024) // 指定列名的长度
	private String headImageUrl;
	/** 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间 */
	@JsonProperty("subscribe_time")
	private long subscribeTime;
	/** 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。 */
	@JsonProperty("unionid")
	private String unionId;
	/** 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注 */
	private String remark;
	/** 用户所在的分组ID（兼容旧的用户分组接口） */
	@JsonProperty("groupid")
	private String groupId;
	/** 用户被打上的标签ID列表 */
	@JsonProperty("tagid_list")
	@Transient // 暂时先不保存，因为数组在保存的时候需要一个独立的表
	private String[] tagIdList;
	/**
	 * 返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，ADD_SCENE_ACCOUNT_MIGRATION
	 * 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，ADD_SCENE_QR_CODE
	 * 扫描二维码，ADD_SCENEPROFILE LINK 图文页内名称点击，ADD_SCENE_PROFILE_ITEM
	 * 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他
	 */
	@JsonProperty("subscribe_scene")
	private String subscribeScene;
	/** 二维码扫码场景（开发者自定义） */
	@JsonProperty("qr_scene")
	private String qrScene;
	/** 二维码扫码场景描述（开发者自定义） */
	@JsonProperty("qr_scene_str")
	private String qrSceneStr;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSubscribe() {
		return subscribe;
	}

	public void setSubscribe(String subscribe) {
		this.subscribe = subscribe;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getHeadImageUrl() {
		return headImageUrl;
	}

	public void setHeadImageUrl(String headImageUrl) {
		this.headImageUrl = headImageUrl;
	}

	public long getSubscribeTime() {
		return subscribeTime;
	}

	public void setSubscribeTime(long subscribeTime) {
		this.subscribeTime = subscribeTime;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String[] getTagIdList() {
		return tagIdList;
	}

	public void setTagIdList(String[] tagIdList) {
		this.tagIdList = tagIdList;
	}

	public String getSubscribeScene() {
		return subscribeScene;
	}

	public void setSubscribeScene(String subscribeScene) {
		this.subscribeScene = subscribeScene;
	}

	public String getQrScene() {
		return qrScene;
	}

	public void setQrScene(String qrScene) {
		this.qrScene = qrScene;
	}

	public String getQrSceneStr() {
		return qrSceneStr;
	}

	public void setQrSceneStr(String qrSceneStr) {
		this.qrSceneStr = qrSceneStr;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
