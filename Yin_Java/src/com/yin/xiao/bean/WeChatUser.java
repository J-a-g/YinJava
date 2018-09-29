package com.yin.xiao.bean;

public class WeChatUser {
	private Integer wechat_uid;
	private String nickName;
	private int gender;
	private String language;
	private String city;
	private String province;
	private String country;
	private String avatarUrl;
	private String signature;
	private Integer uid;
	private Integer businessId;

	@Override
	public String toString() {
		return "WeChatUser [wechat_uid=" + wechat_uid + ", nickName=" + nickName + ", gender=" + gender + ", language="
				+ language + ", city=" + city + ", province=" + province + ", country=" + country + ", avatarUrl="
				+ avatarUrl + ", signature=" + signature + ", uid=" + uid + ", businessId=" + businessId + "]";
	}

	public Integer getWechat_uid() {
		return wechat_uid;
	}

	public void setWechat_uid(Integer wechat_uid) {
		this.wechat_uid = wechat_uid;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAvatarUrl() {
		return avatarUrl;
	}

	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

}
