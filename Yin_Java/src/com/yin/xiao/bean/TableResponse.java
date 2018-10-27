package com.yin.xiao.bean;

import java.util.List;

public class TableResponse {

	private int code;
	private int count;
	private String msg;

	private List<WeChatInfo> data;
	
	
	public TableResponse(int code, int count, String msg, List<WeChatInfo> data) {
		// TODO Auto-generated constructor stub
		this.code = code;
		this.count = count;
		this.msg = msg;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<WeChatInfo> getData() {
		return data;
	}

	public void setData(List<WeChatInfo> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "TestResponse [code=" + code + ", count=" + count + ", msg=" + msg + ", data=" + data + "]";
	}

}
