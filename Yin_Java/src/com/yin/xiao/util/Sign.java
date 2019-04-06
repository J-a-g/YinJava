package com.yin.xiao.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;



public class Sign {
	
	
	public static String sign(SortedMap<Object, Object> paramters, Object key) {

		StringBuffer sb = new StringBuffer();
		Set es = paramters.entrySet();
		Iterator<?> it = es.iterator();
		while (it.hasNext()) {
			@SuppressWarnings("rawtypes")
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			Object v = entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
				sb.append(k + "=" + v + "&");
			}
		}
		System.out.println("sb1:"+sb.toString());
		sb.append("key=" + key);

		String sign = MD5.MD5Encode(sb.toString(), "utf-8").toUpperCase();

		return sign;
	}
	
	
//	public static String sha256_HMAC(SortedMap<Object, Object> paramters, Object key) {
//
//		StringBuffer sb = new StringBuffer();
//		Set es = paramters.entrySet();
//		Iterator<?> it = es.iterator();
//		while (it.hasNext()) {
//			@SuppressWarnings("rawtypes")
//			Map.Entry entry = (Map.Entry) it.next();
//			String k = (String) entry.getKey();
//			Object v = entry.getValue();
//			if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
//				sb.append(k + "=" + v + "&");
//			}
//		}
//		System.out.println("sb2:"+sb.toString());
//		sb.append("key=" + key);
//
//		String sign = Sha256_HMAC.base64Hmac256(key.toString(), sb.toString()).toUpperCase();
//
//		return sign;
//	}
	
}
