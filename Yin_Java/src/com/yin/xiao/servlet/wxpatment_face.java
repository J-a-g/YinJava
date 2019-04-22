package com.yin.xiao.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.yin.xiao.bean.TableResponse;
import com.yin.xiao.bean.WxResponse;
import com.alibaba.fastjson.JSONException;
import com.yin.xiao.SysConfig;
import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.bean.Response;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.control.impl.WeChatInfoControlImpl;
import com.yin.xiao.util.HttpsRequest;
import com.yin.xiao.util.JaxbParser;
import com.yin.xiao.util.Sign;
import com.yin.xiao.util.StrUtil;
import com.yin.xiao.util.WxConfig;
import com.yin.xiao.util.WxPay;
import com.yin.xiao.util.XmlResponse;
import com.yin.xiao.util.Xstream;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class wxpatment_face extends HttpServlet{
	
	private final String TAG = "wxpatment_face";
	private WeChatInfoControl weChatInfoControl = new WeChatInfoControlImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println(TAG + " get...");	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(TAG + " post...");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String rawdata = req.getParameter("rawdata");
		System.out.println("rawdata---> " + rawdata);
		WxPay wxPay = new WxPay();
		wxPay.setAppid("wx5ccd033a77bfd3bf");
//		wxPay.setAppid("wx2b029c08a6232582");
		wxPay.setDevice_id("test0001");
		wxPay.setMch_id("1511694211");
		wxPay.setNonce_str(StrUtil.generateNonceStr());
		wxPay.setNow(String.valueOf(toUnixTimeStamp(System.currentTimeMillis())));
		wxPay.setRawdata(rawdata);
		wxPay.setSign_type("MD5");
		wxPay.setStore_id("testt");
		wxPay.setStore_name("测试");
		wxPay.setVersion("1");

		SortedMap<Object, Object> map = new TreeMap<>();

		map.put("appid", wxPay.getAppid());
		map.put("mch_id", wxPay.getMch_id());
		map.put("version", wxPay.getVersion());
		map.put("sign_type", wxPay.getSign_type());
		map.put("store_id", wxPay.getStore_id());
		map.put("store_name", wxPay.getStore_name());
		map.put("device_id", wxPay.getDevice_id());
		map.put("nonce_str", wxPay.getNonce_str());
		map.put("rawdata", wxPay.getRawdata());
		map.put("now", wxPay.getNow());
//		String sign  = WxConfig.createSign(map);
		String sign2 = Sign.sign(map, "yindiankejixuhui6666666666666666");
//		System.out.println("aaa-->  " + sign);
		System.out.println("bbbb-->  " + sign2);
		wxPay.setSign(sign2);
		System.out.println("00 ---> " + wxPay.toString());
		Xstream.xstream.alias("xml", WxPay.class);
		System.out.println("wxPay:::");
		String xml = Xstream.xstream.toXML(wxPay);
		xml = xml.replaceAll("__", "_");
		System.out.println("11---> " + xml);
		JSONObject userJson = null;
		try {
			String res = HttpsRequest.httpsRequest("https://payapp.weixin.qq.com/face/get_wxpayface_authinfo", "POST",
					xml);
			System.out.println("22 ---> " + res);
			JaxbParser jaxbParser = new JaxbParser(XmlResponse.class);
			XmlResponse response = (XmlResponse) jaxbParser.toObj(res);
			System.out.println("33 ---> " + response.toString());
			System.out.println("444 ---> " + response.getAuthinfo());
			userJson = JSONObject.fromObject(new WxResponse(SysConfig.SUC_CODE, "验证成功", response));
			System.out.println("json---> " + userJson.toString());
			PrintWriter out = resp.getWriter();
			out.println(userJson.toString());
			out.flush();
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// super.init(config);
		System.out.println("wxpatment_face init...");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println(TAG + " destroy");
	}
	
	private long toUnixTimeStamp(long timestamp) {
		return timestamp / 1000;
	}

}
