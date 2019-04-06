package com.yin.xiao.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
public class XmlResponse {

	private String return_code;
	private String return_msg;
	private String nonce_str;
	private String sign;
	private String authinfo;
	private String expires_in;
	private String appid;
	private String mch_id;

	@XmlElement(name = "return_code")
	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	@XmlElement(name = "return_msg")
	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	@XmlElement(name = "nonce_str")
	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	@XmlElement(name = "sign")
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	@XmlElement(name = "authinfo")
	public String getAuthinfo() {
		return authinfo;
	}

	public void setAuthinfo(String authinfo) {
		this.authinfo = authinfo;
	}

	@XmlElement(name = "expires_in")
	public String getExpires_in() {
		return expires_in;
	}

	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}

	@XmlElement(name = "appid")
	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	@XmlElement(name = "mch_id")
	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	@Override
	public String toString() {
		return "XmlResponse [return_code=" + return_code + ", return_msg=" + return_msg + ", nonce_str=" + nonce_str
				+ ", sign=" + sign + ", authinfo=" + authinfo + ", expires_in=" + expires_in + ", appid=" + appid
				+ ", mch_id=" + mch_id + "]";
	}

}
