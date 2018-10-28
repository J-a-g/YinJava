package com.yin.xiao.control.impl;

import com.yin.xiao.control.BusinessControl;
import com.yin.xiao.dao.BusinessDao;
import com.yin.xiao.dao.impl.BusinessDaoImpl;

public class BusinessControlImpl implements BusinessControl{
	
	private BusinessDao businessDao = new BusinessDaoImpl();

	@Override
	public boolean del_Business(int businessId) {
		// TODO Auto-generated method stub
		return businessDao.delBusiness(businessId);
	}

	@Override
	public boolean update_Business_status(int businessId, int status) {
		// TODO Auto-generated method stub
		return businessDao.updateBusinessStatus(businessId, status);
	}

	@Override
	public boolean recover_Business(int businessId) {
		// TODO Auto-generated method stub
		return businessDao.recoverBusiness(businessId);
	}

}
