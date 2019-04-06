package com.yin.xiao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.SortedMap;
import java.util.TreeMap;

import com.mysql.fabric.xmlrpc.base.Struct;
import com.sun.xml.internal.ws.util.StreamUtils;
import com.thoughtworks.xstream.XStream;
import com.yin.xiao.bean.Admin;
import com.yin.xiao.util.HttpsRequest;
import com.yin.xiao.util.JaxbParser;
import com.yin.xiao.util.Sign;
import com.yin.xiao.util.StrUtil;
import com.yin.xiao.util.WxConfig;
import com.yin.xiao.util.WxPay;
import com.yin.xiao.util.XmlResponse;
import com.yin.xiao.util.Xstream;

import net.sf.json.JSONObject;

public class TestMain {

	public String load(String url, String query) throws Exception {
		URL restURL = new URL(url);
		/*
		 * 此处的urlConnection对象实际上是根据URL的请求协议(此处是http)生成的URLConnection类
		 * 的子类HttpURLConnection
		 */
		HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
		// 请求方式
		conn.setRequestMethod("POST");
		// 设置是否从httpUrlConnection读入，默认情况下是true; httpUrlConnection.setDoInput(true);
		conn.setDoOutput(true);
		// allowUserInteraction 如果为 true，则在允许用户交互（例如弹出一个验证对话框）的上下文中对此 URL 进行检查。
		conn.setAllowUserInteraction(false);
		// conn.setRequestProperty("Content-type", "text/html");
		PrintStream ps = new PrintStream(conn.getOutputStream());
		ps.print(query);
		ps.close();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
		String line, resultStr = "";
		while (null != (line = bReader.readLine())) {
			resultStr += line;
		}
		System.out.println("3412412---" + resultStr);
		bReader.close();
		return resultStr;
	}

	public void test() {
		try {
			URL url = new URL("http://localhost:8080/Yin_Java/wxpatment_face");
			String xml = "<aaa><ddd>cccccc客户端请求的xml数据cccccccc</ddd></aaa>";
			URLConnection conn = null;
			conn = url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-Length", Integer.toString(xml.length()));
			conn.setRequestProperty("Content-Type", "text/html; charset=utf-8");
			OutputStream ops = conn.getOutputStream();
			OutputStreamWriter osw;
			osw = new OutputStreamWriter(ops, "GBK");
			osw.write(xml);
			osw.flush();
			osw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public long toUnixTimeStamp(long timestamp) {
		return timestamp / 1000;
	}

	public static void main(String str[]) {
		// Admin admin = new Admin();
		// admin.setAdmin_pwd("98764");
		// admin.setAdmin_username("rootssss");
		// admin.setPower("1,2,3");
		// admin.setAdmin_uid(3);
		// JSONObject json = JSONObject.fromObject(admin);
		// System.out.println(json.toString());

		// try {
		//
		TestMain restUtil = new TestMain();
		// restUtil.test();
		//// https://payapp.weixin.qq.com/face/get_wxpayface_authinfo
		// //http://localhost:8080/Yin_Java/WebLogin?username=root&password=888888
		// String resultString = restUtil.load(
		// "http://localhost:8080/Yin_Java/WebLogin",
		// "username=alsdfjalkdj&password=446456");
		// } catch (Exception e) {
		// System.out.print(e.getMessage());
		// }

		System.out.println("KKK---> " + String.valueOf(restUtil.toUnixTimeStamp(System.currentTimeMillis())));
		WxPay wxPay = new WxPay();
		wxPay.setAppid("wx5ccd033a77bfd3bf");
//		wxPay.setAppid("wx2b029c08a6232582");
		wxPay.setDevice_id("test0001");
		wxPay.setMch_id("1511694211");
		wxPay.setNonce_str(StrUtil.generateNonceStr());
		wxPay.setNow(String.valueOf(restUtil.toUnixTimeStamp(System.currentTimeMillis())));
		wxPay.setRawdata(
				"9lru2z3LR6awHOLQQ2ahoowxK8Sm8Zo8G1tW3b5KsDIdN6beIxr9ag6XwMFVif9fzz16Tb+EKIea4sN58Rn4XFTomKtQ62mQM4a9JGt+nmcXFBRBY5CYosyOnYfwVfeHO3ic6ss77k1lbxsj91mZXk5agZaHsn3LV4Vo43mDyE0Bq1e51VWEi2FEez69Cj+nQ4HCYtf5YAK2QjSPZFXeNyYaFynroci8E6lmRnATJ21rPGWtMDhY9Ju+yrLwzBM2cwpOTUVgyYZRiojFPPMR1YmSDp9WmwdsCjdjVSrLzRkOtN3ztt0HawZTiJJtNLT0CUK4SWgPBY6yivLZGJpj6ztv54JFOK2FqoCY875pwtR4phhCMHvkCN/+B3iRVEoFpcz8wvgcva99r2EOdLj/BTnYbnd8j85WlNev9p8j4+WvINbHKNSq3IOnZm5Zmx1B+xQPSCcQnz6TQsgG1iBmy1lZV0b6CyernFV0+C4o");
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
		String sign  = WxConfig.createSign(map);
		String sign2 = Sign.sign(map, "yindiankejixuhui6666666666666666");
		System.out.println("aaa-->  " + sign);
		System.out.println("bbbb-->  " + sign2);
		wxPay.setSign(sign2);
		System.out.println("00 ---> " + wxPay.toString());
		Xstream.xstream.alias("xml", WxPay.class);
		String xml = Xstream.xstream.toXML(wxPay);
		xml = xml.replaceAll("__", "_");
		System.out.println("11---> " + xml);
		try {
			String resp = HttpsRequest.httpsRequest("https://payapp.weixin.qq.com/face/get_wxpayface_authinfo", "POST",
					xml);
			System.out.println("22 ---> " + resp);
			JaxbParser jaxbParser = new JaxbParser(XmlResponse.class);
			XmlResponse response = (XmlResponse) jaxbParser.toObj(resp);
			System.out.println("33 ---> " + response.toString());
			System.out.println("444 ---> " + response.getAuthinfo());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
