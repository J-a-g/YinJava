package com.yin.xiao;

import com.yin.xiao.bean.Admin;

import net.sf.json.JSONObject;

public class TestMain {
	public static void main(String str[]) {
		Admin admin = new Admin();
		admin.setAdmin_pwd("98764");
		admin.setAdmin_username("rootssss");
		admin.setPower("1,2,3");
		admin.setAdmin_uid(3);
		JSONObject json = JSONObject.fromObject(admin);
		System.out.println(json.toString());
		
		
	}
}
