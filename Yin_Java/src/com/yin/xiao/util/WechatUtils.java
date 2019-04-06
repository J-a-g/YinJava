package com.yin.xiao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class WechatUtils {
	
	
	/**
	 * ½âÎöÇëÇó·µ»Ø×Ö·û´®
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static String parseStringFormRequest(HttpServletRequest request)
			throws IOException {
		InputStream in = request.getInputStream();

		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		
		return out.toString();
	}
	
	
}
