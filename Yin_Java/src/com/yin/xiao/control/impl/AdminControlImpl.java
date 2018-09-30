package com.yin.xiao.control.impl;

import com.yin.xiao.control.AdminControl;
import com.yin.xiao.dao.AdminDao;
import com.yin.xiao.dao.impl.AdminDaoImpl;

public class AdminControlImpl implements AdminControl{
	
	private AdminDao adminDao = new AdminDaoImpl();

	@Override
	public boolean login(String admin_username, String admin_pwd) {
		// TODO Auto-generated method stub
		return adminDao.login(admin_username,  admin_pwd);
	}
}
