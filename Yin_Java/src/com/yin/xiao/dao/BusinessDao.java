package com.yin.xiao.dao;

public interface BusinessDao {

	public boolean recoverBusiness(int businessId);

	public boolean delBusiness(int businessId);

	public boolean updateBusinessStatus(int businessId, int status);

}
