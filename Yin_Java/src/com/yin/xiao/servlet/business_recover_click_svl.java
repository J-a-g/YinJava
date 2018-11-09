package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.xiao.SysConfig;
import com.yin.xiao.bean.Response;
import com.yin.xiao.control.BusinessControl;
import com.yin.xiao.control.UserControl;
import com.yin.xiao.control.impl.BusinessControlImpl;
import com.yin.xiao.control.impl.UserControlImpl;

import net.sf.json.JSONObject;

public class business_recover_click_svl extends HttpServlet{
	private final String TAG = "business_recover_click_svl";
	private BusinessControl businessControl = new BusinessControlImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println(TAG + " doGet");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(TAG + " doPost");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String businessId = req.getParameter("businessId");// 接受用户的参数
		JSONObject userJson;
		if(businessControl.recover_Business(Integer.parseInt(businessId))) {
			userJson = JSONObject.fromObject(new Response(SysConfig.SUC_CODE, "恢复成功", "", "business_recover_click_svl"));
		}else {
			userJson = JSONObject.fromObject(new Response(SysConfig.ERR_CODE, "恢复失败", "", "business_recover_click_svl"));
		}
		System.out.println("business_recover_click_svl--->" + userJson.toString());
		PrintWriter out = resp.getWriter();
		out.println(userJson.toString());
		out.flush();
		out.close();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);
		System.out.println(TAG + " init...");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println(TAG + " destroy");
	}
	
}
