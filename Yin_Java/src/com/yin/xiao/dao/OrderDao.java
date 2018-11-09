package com.yin.xiao.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.yin.xiao.bean.Order;
import com.yin.xiao.bean.Orderlist_Html_Bean;

public interface OrderDao {
	public void insertOrder(Order order);
	
	public List<Orderlist_Html_Bean> queryOrder(int index);
	
	public void updateOder(Order order); 
}
