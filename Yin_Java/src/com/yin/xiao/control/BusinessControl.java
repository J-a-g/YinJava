package com.yin.xiao.control;

public interface BusinessControl {
	public boolean del_Business(int businessId);
	
	public boolean update_Business_status(int businessId, int status);
	
	public boolean recover_Business(int businessId);
}
