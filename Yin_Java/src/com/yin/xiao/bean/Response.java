package com.yin.xiao.bean;

public class Response {
	private String errCode;
	private String errMsg;
	private String data;
	private String interFace;

	
	public Response(String errCode, String errMsg, String data, String interFace) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.data = data;
		this.interFace = interFace;
	}
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getInterFace() {
		return interFace;
	}

	public void setInterFace(String interFace) {
		this.interFace = interFace;
	}

	@Override
	public String toString() {
		return "Response [errCode=" + errCode + ", errMsg=" + errMsg + ", data=" + data + ", interFace=" + interFace
				+ "]";
	}

}
