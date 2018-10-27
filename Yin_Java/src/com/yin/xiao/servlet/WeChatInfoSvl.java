package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yin.xiao.SysConfig;
import com.yin.xiao.bean.Test2Response;
import com.yin.xiao.bean.TableResponse;
import com.yin.xiao.bean.WeChatInfo;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.control.impl.WeChatInfoControlImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeChatInfoSvl extends HttpServlet{
	
	private final String TAG = "WeChatInfo Servlet";
	private WeChatInfoControl weChatInfoControl = new WeChatInfoControlImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println(TAG + " get...");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String page = req.getParameter("page");// �����û��Ĳ���
		String limit = req.getParameter("limit");
		System.out.println("page -----> " + page + " limit ---> " + limit);
		List<WeChatInfo> list = weChatInfoControl.getWeChatInfos(Integer.parseInt(page) - 1);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(TAG + " post...");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String page = req.getParameter("page");// �����û��Ĳ���
		String limit = req.getParameter("limit");
		System.out.println("page -----> " + page + " limit ---> " + limit);
		List<WeChatInfo> list = weChatInfoControl.getWeChatInfos(Integer.parseInt(page) - 1);
		
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println("jsonArray ----> " + jsonArray.toString());
		JSONObject jsonObject = JSONObject.fromObject(new TableResponse(0, 1000, "", list));
//		JSONObject jsonObject = JSONObject.fromObject(new Test2Response<WeChatInfo>(0, "�ɹ�", 1000, list));
		System.out.println("json---> " + jsonObject.toString());
		PrintWriter out = resp.getWriter();
		
		out.println(jsonObject.toString());
		out.flush();
		out.close();
		
//		String password = req.getParameter("password");
//		JSONObject userJson;
//		if (adminControl.login(username, password)) {
//			userJson = JSONObject.fromObject(new Response("0000", "��֤�ɹ�", "", "WebLogin"));
//		} else {
//			userJson = JSONObject.fromObject(new Response("1001", "��֤ʧ��", "", "WebLogin"));
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
