package com.yin.xiao.bean;

import java.util.List;

public class Test2Response<T> {
	private int errCode;
	private String errMsg;
	private int total;
	private List<T> data;
//	private String interFace;

	public Test2Response(int errCode, String errMsg, int total, List<T> data) {
		this.errCode = errCode;
		this.errMsg = errMsg;
		this.total = total;
		this.data = data;
//		this.interFace = interFace;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getErrCode() {
		return errCode;
	}

	public void setErrCode(int errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

//	public String getInterFace() {
//		return interFace;
//	}
//
//	public void setInterFace(String interFace) {
//		this.interFace = interFace;
//	}

	@Override
	public String toString() {
		return "TableResponse [errCode=" + errCode + ", errMsg=" + errMsg + ", total=" + total + ", data=" + data
				+ ", interFace=]";
	}

}
