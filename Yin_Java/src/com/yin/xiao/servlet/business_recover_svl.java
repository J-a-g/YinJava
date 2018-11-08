package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.xiao.SysConfig;
import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.bean.Response;
import com.yin.xiao.bean.TableResponse;
import com.yin.xiao.control.BusinessControl;
import com.yin.xiao.control.UserControl;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.control.impl.BusinessControlImpl;
import com.yin.xiao.control.impl.UserControlImpl;
import com.yin.xiao.control.impl.WeChatInfoControlImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class business_recover_svl extends HttpServlet{
	private final String TAG = "business_recover_svl";
	private WeChatInfoControl weChatInfoControl = new WeChatInfoControlImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		System.out.println(TAG + " get...");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		System.out.println(TAG + " post...");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String page = req.getParameter("page");// 接受用户的参数
		List<MemberBean> list = weChatInfoControl.getBusinessIsDel(Integer.parseInt(page) - 1);
		JSONObject jsonObject = JSONObject.fromObject(new TableResponse<MemberBean>(0, "成功", 1000, list));
		System.out.println("json---> " + jsonObject.toString());
		PrintWriter out = resp.getWriter();	
		out.println(jsonObject.toString());
		out.flush();
		out.close();
	}
	

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		// super.init(config);
		System.out.println(TAG + " init...");
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println(TAG + " destroy");
	}
	
}
