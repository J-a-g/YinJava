package com.yin.xiao.util;

public class WxPay {
	private String appid;
	private String mch_id;
	private String version;
	private String sign_type;
	private String store_id;
	private String store_name;
	private String device_id;
	private String nonce_str;
	private String rawdata;
	private String now;
	private String sign;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getSign_type() {
		return sign_type;
	}
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}
	public String getStore_id() {
		return store_id;
	}
	public void setStore_id(String store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public String getDevice_id() {
		return device_id;
	}
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getRawdata() {
		return rawdata;
	}
	public void setRawdata(String rawdata) {
		this.rawdata = rawdata;
	}
	public String getNow() {
		return now;
	}
	public void setNow(String now) {
		this.now = now;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	@Override
	public String toString() {
		return "WxPay [appid=" + appid + ", mch_id=" + mch_id + ", version=" + version + ", sign_type=" + sign_type
				+ ", store_id=" + store_id + ", store_name=" + store_name + ", device_id=" + device_id + ", nonce_str="
				+ nonce_str + ", rawdata=" + rawdata + ", now=" + now + ", sign=" + sign + "]";
	}
	
	
}
