package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.xiao.bean.Response;
import com.yin.xiao.control.AdminControl;
import com.yin.xiao.control.impl.AdminControlImpl;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
import sun.management.resources.agent;

public class WebLogin extends HttpServlet {

	private AdminControl adminControl = new AdminControlImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		System.out.println("JAG post...");

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String username = req.getParameter("username");// �����û��Ĳ���
		String password = req.getParameter("password");
		JSONObject userJson;
		if (adminControl.login(username, password)) {
			userJson = JSONObject.fromObject(new Response("0000", "��֤�ɹ�", "", "WebLogin"));
		} else {
			userJson = JSONObject.fromObject(new Response("1001", "��֤ʧ��", "", "WebLogin"));
		}
		System.out.println("json---> " + userJson.toString());
		PrintWriter out = resp.getWriter();
		
		out.println(userJson.toString());
		out.flush();
		out.close();

	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// super.init(config);
		System.out.println("JAG init...");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println("JAG destroy...");
	}

}