package com.yin.xiao.control;

public interface UserControl {
	public boolean del_User(int uid);
	
	public boolean update_User_status(int uid, int status);
	
	public boolean recover_User(int uid);

}
