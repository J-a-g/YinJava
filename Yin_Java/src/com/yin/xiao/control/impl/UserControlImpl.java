package com.yin.xiao.control.impl;

import com.yin.xiao.control.UserControl;
import com.yin.xiao.dao.UserDao;
import com.yin.xiao.dao.impl.UserDaoImpl;

public class UserControlImpl implements UserControl{

	private UserDao userDao = new UserDaoImpl(); 
	
	@Override
	public boolean del_User(int uid) {
		// TODO Auto-generated method stub
		return userDao.delUser(uid);
	}

	@Override
	public boolean update_User_status(int uid, int status) {
		// TODO Auto-generated method stub
		return userDao.updateUserStatus(uid, status);
	}

	@Override
	public boolean recover_User(int uid) {
		// TODO Auto-generated method stub
		return userDao.recoverUser(uid);
	}

}
