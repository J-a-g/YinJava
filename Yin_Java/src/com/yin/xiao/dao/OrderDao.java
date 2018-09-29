package com.yin.xiao.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.yin.xiao.bean.Order;

public interface OrderDao {
	public void insertOrder(Order order);
	
	public List<Order> queryOrder(int index, int length);
	
	public void updateOder(Order order); 
}
