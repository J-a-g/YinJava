package com.yin.xiao.dao;

public interface UserDao {
	public boolean recoverUser(int uid);
	
	public boolean delUser(int uid);
	
	public boolean updateUserStatus(int uid, int status);
}
