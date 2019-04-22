package com.yin.xiao.bean;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import com.yin.xiao.util.XmlResponse;

public class WxResponse {
	private String return_code;
	private String return_msg;
	private XmlResponse xmlResponse;
	
	
	public WxResponse(String return_code, String return_msg, XmlResponse xmlResponse) {
		// TODO Auto-generated constructor stub
		this.return_code = return_code;
		this.return_msg = return_msg;
		this.xmlResponse = xmlResponse;
	}

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public XmlResponse getXmlResponse() {
		return xmlResponse;
	}

	public void setXmlResponse(XmlResponse xmlResponse) {
		this.xmlResponse = xmlResponse;
	}

	@Override
	public String toString() {
		return "WxResponse [return_code=" + return_code + ", return_msg=" + return_msg + ", xmlResponse=" + xmlResponse
				+ "]";
	}

}
