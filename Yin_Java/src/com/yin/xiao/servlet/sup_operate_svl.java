package com.yin.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yin.xiao.Operate;
import com.yin.xiao.SysConfig;
import com.yin.xiao.bean.Response;
import com.yin.xiao.control.OperateControl;
import com.yin.xiao.control.impl.OperateControlImpl;

import net.sf.json.JSONObject;

public class sup_operate_svl extends HttpServlet {

	private final String TAG = "sup_operate_svl";
	private OperateControl operateControl = new OperateControlImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		System.out.println(TAG + " get...");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String machineSn = req.getParameter("machineSn");
		String type = req.getParameter("type");
		String mark = req.getParameter("mark");
		Operate operate = new Operate();
		operate.setMachineSn(machineSn);
		operate.setMark("苏城建" + mark);
		
		operate.setType(Integer.parseInt(type));
		System.out.println(operate.toString());
		JSONObject jsonObject;
		if (operateControl.insertOperateControl(operate)) {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.SUC_CODE, "成功", "", "sup_operate_svl"));
		} else {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.ERR_CODE, "失败", "", "sup_operate_svl"));
		}
		System.out.println("json---> " + jsonObject.toString());
		PrintWriter out = resp.getWriter();
		out.println(jsonObject.toString());
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		System.out.println(TAG + " post...");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String machineSn = req.getParameter("machineSn");
		String type = req.getParameter("type");
		String mark = req.getParameter("mark");
		Operate operate = new Operate();
		operate.setMachineSn(machineSn);
		operate.setMark(mark);
		operate.setType(Integer.parseInt(type));
		JSONObject jsonObject;
		if (operateControl.insertOperateControl(operate)) {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.SUC_CODE, "成功", "", "sup_operate_svl"));
		} else {
			jsonObject = JSONObject.fromObject(new Response(SysConfig.ERR_CODE, "失败", "", "sup_operate_svl"));
		}
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
		System.out.println("sup_operate_svl init...");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
		System.out.println(TAG + " destroy");
	}

}
