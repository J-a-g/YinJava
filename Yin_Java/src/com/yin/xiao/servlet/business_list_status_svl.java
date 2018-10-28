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

public class business_list_status_svl extends HttpServlet{
	private final String TAG = "business_list_status_svl";
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
		String status = req.getParameter("status");
		System.out.println("uid ----> " + businessId + " status ---> " + status);
		JSONObject jsonObject;
		if(businessControl.update_Business_status(Integer.parseInt(businessId), Integer.parseInt(status))) {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.SUC_CODE, "修改成功", "", "business_list_status_svl"));
		}else {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.ERR_CODE, "修改失败", "", "business_list_status_svl"));
		}
		System.out.println("business_list_status_svl--->" + jsonObject.toString());
		PrintWriter out = resp.getWriter();
		out.println(jsonObject.toString());
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
