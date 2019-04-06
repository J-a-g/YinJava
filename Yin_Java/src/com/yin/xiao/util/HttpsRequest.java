package com.yin.xiao.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;






public class HttpsRequest {
	public static String doGet(String url) throws Exception {

		URL localURL = new URL(url);

		URLConnection connection = localURL.openConnection();
		HttpURLConnection httpURLConnection = (HttpURLConnection) connection;

		httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
		httpURLConnection.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");

		InputStream inputStream = null;
		InputStreamReader inputStreamReader = null;
		BufferedReader reader = null;
		StringBuffer resultBuffer = new StringBuffer();
		String tempLine = null;

		if (httpURLConnection.getResponseCode() >= 300) {
			throw new Exception(
					"HTTP Request is not success, Response code is "
							+ httpURLConnection.getResponseCode());
		}
		try {
			inputStream = httpURLConnection.getInputStream();
			inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
			reader = new BufferedReader(inputStreamReader);

			while ((tempLine = reader.readLine()) != null) {
				resultBuffer.append(tempLine);
			}

		} finally {
			if (reader != null) {
				reader.close();
			}
			if (inputStreamReader != null) {
				inputStreamReader.close();
			}
			if (inputStream != null) {
				inputStream.close();
			}
			// 关掉httpURLConnection产生的相关流。就可以了httpURLConnection不需要手动释放
		}

		return resultBuffer.toString();
	}
	
	public static String sendPost(String url, String param) throws IOException {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";

		URL realUrl = new URL(url);
		// 打开和URL之间的连接

		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) realUrl.openConnection();

		// 设置通用的请求属性
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");

		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// 发送POST请求必须设置如下两行
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// 获取URLConnection对象对应的输出流
		out = new PrintWriter(conn.getOutputStream());
		

		// 发送请求参数
		out.print(param);
		// flush输出流的缓冲
		out.flush();
		int state = conn.getResponseCode();
		if (state != 200) {
			return "fail";
		}
		System.out.println("state:" + conn.getResponseCode());
		// 定义BufferedReader输入流来读取URL的响应
		in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}

		// 使用finally块来关闭输出流、输入流
		try {
			if (out != null) {
				out.close();
			}
			if (in != null) {
				in.close();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}

		return result;
	}


	public static String httpsRequest(String requestUrl, String requestMethod,
			String outStr) throws Exception {

		// 创建 SSLContext
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		TrustManager[] tm = { new MyX509TrustManager() };
		// 初始化
		sslContext.init(null, tm, new java.security.SecureRandom());
		// 获取sslSOCKETfactory对象
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// 设置当前实例使用sslSOCKETfactory
		StringBuffer buffer = null;
		URL url = new URL(requestUrl);
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
		conn.setRequestMethod(requestMethod);
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setSSLSocketFactory(ssf);
		conn.connect();
		if (outStr != null) {
			OutputStream os = conn.getOutputStream();
			os.write(outStr.getBytes("UTF-8"));
			os.close();
		}
		// 读取服务端的内容
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		buffer = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
		// 打印数据
		// System.out.println(buffer.toString());
	}
}
