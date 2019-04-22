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
			// �ص�httpURLConnection��������������Ϳ�����httpURLConnection����Ҫ�ֶ��ͷ�
		}

		return resultBuffer.toString();
	}
	
	public static String sendPost(String url, String param) throws IOException {
		PrintWriter out = null;
		BufferedReader in = null;
		String result = "";

		URL realUrl = new URL(url);
		// �򿪺�URL֮�������

		java.net.HttpURLConnection conn = (java.net.HttpURLConnection) realUrl.openConnection();

		// ����ͨ�õ���������
		conn.setRequestProperty("accept", "*/*");
		conn.setRequestProperty("connection", "Keep-Alive");

		conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

		// ����POST�������������������
		conn.setDoOutput(true);
		conn.setDoInput(true);
		// ��ȡURLConnection�����Ӧ�������
		out = new PrintWriter(conn.getOutputStream());
		

		// �����������
		out.print(param);
		// flush������Ļ���
		out.flush();
		int state = conn.getResponseCode();
		if (state != 200) {
			return "fail";
		}
		System.out.println("state:" + conn.getResponseCode());
		// ����BufferedReader����������ȡURL����Ӧ
		in = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
		String line;
		while ((line = in.readLine()) != null) {
			result += line;
		}

		// ʹ��finally�����ر��������������
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

		// ���� SSLContext
		SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
		TrustManager[] tm = { new MyX509TrustManager() };
		// ��ʼ��
		sslContext.init(null, tm, new java.security.SecureRandom());
		// ��ȡsslSOCKETfactory����
		SSLSocketFactory ssf = sslContext.getSocketFactory();
		// ���õ�ǰʵ��ʹ��sslSOCKETfactory
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
		// ��ȡ����˵�����
		InputStream is = conn.getInputStream();
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		buffer = new StringBuffer();
		String line = null;
		while ((line = br.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
		// ��ӡ����
		// System.out.println(buffer.toString());
	}
}
