package com.yin.xiao.control.impl;

import java.util.List;

import com.yin.xiao.bean.Orderlist_Html_Bean;
import com.yin.xiao.control.OrdreControl;
import com.yin.xiao.dao.OrderDao;
import com.yin.xiao.dao.impl.OrderDaoImpl;

public class OrderControlImpl implements OrdreControl{
	
	private OrderDao orderDao = new OrderDaoImpl();

	@Override
	public List<Orderlist_Html_Bean> queryOrder_control(int index) {
		// TODO Auto-generated method stub
		return orderDao.queryOrder(index);
	}

}
