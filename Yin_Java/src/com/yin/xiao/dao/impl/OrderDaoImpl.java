package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.bean.Order;
import com.yin.xiao.bean.Orderlist_Html_Bean;
import com.yin.xiao.dao.OrderDao;
import com.yin.xiao.util.DBUtil;

public class OrderDaoImpl implements OrderDao{
	
	private int length = 10;

	@Override
	public void insertOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Orderlist_Html_Bean> queryOrder(int index) {
		int start = index * length;
		List<Orderlist_Html_Bean> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select orderId, order_sn, mark,order_price,order_status,pay_status,pay_type,o.create_time, w.nickName, w2.nickName, "
					+ "kitchenName from `order` o, wechat_info w, wechat_info w2, kitchen k, business b where o.wechat_uid_user = w.wechat_uid"
					+ " && o.wechat_uid_business = w2.wechat_uid && k.businessId = b.businessId && o.del = 0 ORDER BY orderId asc limit " + start + ", "
					+ length;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// 结果集(rs)的结构信息，比如字段数、字段名等。
			// int columnCount = md.getColumnCount();// 取得查询出来的字段个数
			while (rs.next()) {// 迭代rs
				Orderlist_Html_Bean orderlist_Html_Bean = new Orderlist_Html_Bean();
				orderlist_Html_Bean.setOrderId(rs.getInt("orderId"));
				orderlist_Html_Bean.setBusiness_nickName(rs.getString("w2.nickName"));
				orderlist_Html_Bean.setUser_nickName(rs.getString("w.nickName"));
				orderlist_Html_Bean.setCreate_time(rs.getString("create_time"));
				orderlist_Html_Bean.setKitchenName(rs.getString("kitchenName"));
				orderlist_Html_Bean.setMark(rs.getString("mark"));
				orderlist_Html_Bean.setOrder_price(rs.getFloat("order_price"));
				orderlist_Html_Bean.setOrder_sn(rs.getString("order_sn"));
				orderlist_Html_Bean.setOrder_status(rs.getInt("order_status"));
				orderlist_Html_Bean.setPay_status(rs.getInt("pay_status"));
				orderlist_Html_Bean.setPay_type(rs.getInt("pay_type"));
				if(rs.getInt("order_status") == 0) {
					orderlist_Html_Bean.setStr_order_status("未处理");
				}else if(rs.getInt("order_status") == 1){
					orderlist_Html_Bean.setStr_order_status("已接单");
				}else if(rs.getInt("order_status") == 2) {
					orderlist_Html_Bean.setStr_order_status("已完成");
				}else if(rs.getInt("order_status") == 3) {
					orderlist_Html_Bean.setStr_order_status("关闭");
				}
				
				if(rs.getInt("pay_status") == 0) {
					orderlist_Html_Bean.setStr_pay_status("到付");
				}else if(rs.getInt("pay_status") == 1) {
					orderlist_Html_Bean.setStr_pay_status("已支付");
				}
				
				if(rs.getInt("pay_type") == 0) {
					orderlist_Html_Bean.setStr_pay_type("微信");
				}else if(rs.getInt("pay_type") == 1) {
					orderlist_Html_Bean.setStr_pay_type("支付宝");
				}else if(rs.getInt("pay_type") == 2) {
					orderlist_Html_Bean.setStr_pay_type("现金");
				}
				
				list.add(orderlist_Html_Bean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public void updateOder(Order order) {
		// TODO Auto-generated method stub
		
	}

}
