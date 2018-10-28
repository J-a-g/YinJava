package com.yin.xiao.bean;

/**
 * 会员数据
 * 
 * @author suche
 *
 */
public class MemberBean {

	// select nickName, gender, language, city, signature, phone_number, address,
	// del, create_time from wechat_info w, user u where w.uid=u.uid && u.del = 0

	private int wechat_uid;
	private int uid;
	private int businessId;
	private String status;
	private String nickName;
	private String gender;
	private String city;
	private String country;
	private String province;
	private String signature;
	private String phone_number;
	private String address;
	private String create_time;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getWechat_uid() {
		return wechat_uid;
	}

	public void setWechat_uid(int wechat_uid) {
		this.wechat_uid = wechat_uid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getBusinessId() {
		return businessId;
	}

	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		return "MemberBean [wechat_uid=" + wechat_uid + ", uid=" + uid + ", businessId=" + businessId + ", status="
				+ status + ", nickName=" + nickName + ", gender=" + gender + ", city=" + city + ", country=" + country
				+ ", province=" + province + ", signature=" + signature + ", phone_number=" + phone_number
				+ ", address=" + address + ", create_time=" + create_time + "]";
	}

}
