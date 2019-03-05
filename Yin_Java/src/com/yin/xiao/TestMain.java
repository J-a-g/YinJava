package com.yin.xiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yin.xiao.bean.Admin;
import com.yin.xiao.servlet.order_list_svl;

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
		List<TestBean> list = new ArrayList<>();
		Map<Integer, String> map = new HashMap<>();
		for(int i = 0; i < 1000; i++) {
			TestBean testBean = new TestBean();
			testBean.setId(i);
			testBean.setReString("xxxxxxxxxxxxxx,aaaaaaaaaaaaaa,bbbbbbbbbbbbbbbbbb,cccccccccccccccccccccccccccc,"
					+ "ddddddddddddddddddddddddddddd,eeeeeeeeeeeeeeeeeeeeeeeeeee,fffffffffffffffffffffffffffff,"
					+ "ggggggggggggggggggggggggggggg,hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
			list.add(testBean);
			map.put(i, testBean.getReString());
		}
		List<String> list2 = new ArrayList<>();
		
		for(int i = 0; i < 1005; i ++) {
			for(Integer key : map.keySet()) {
				if(key == i) {
					System.out.println("key-->" + key + " value--> " + map.get(key));
					list2.add(map.get(key));
				}
			}
		}
		
		System.out.println("list2 ---> " + list2.size());
		
	}
}
