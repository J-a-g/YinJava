package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.xiao.bean.Response;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.control.impl.WeChatInfoControlImpl;

import net.sf.json.JSONObject;

public class WeChatInfo extends HttpServlet{
	
	private final String TAG = "WeChatInfo Servlet";
	private WeChatInfoControl weChatInfoControl = new WeChatInfoControlImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println(TAG + "get...");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String index = req.getParameter("index");// 接受用户的参数
		System.out.println("index -----> " + index);
		weChatInfoControl.getWeChatInfos(Integer.parseInt(index));
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(TAG + "post...");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String index = req.getParameter("index");// 接受用户的参数
		System.out.println("index -----> " + index);
//		String password = req.getParameter("password");
//		JSONObject userJson;
//		if (adminControl.login(username, password)) {
//			userJson = JSONObject.fromObject(new Response("0000", "验证成功", "", "WebLogin"));
//		} else {
//			userJson = JSONObject.fromObject(new Response("1001", "验证失败", "", "WebLogin"));
//		}
//		System.out.println("json---> " + userJson.toString());
//		PrintWriter out = resp.getWriter();
//		
//		out.println(userJson.toString());
//		out.flush();
//		out.close();
	}
	
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		System.out.println("WeChatInfo Servlet init");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("WeChatInfo Servlet destroy");
	}

}
