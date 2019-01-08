package com.yin.xiao.control.impl;

import com.yin.xiao.Operate;
import com.yin.xiao.control.OperateControl;
import com.yin.xiao.dao.OperateDao;
import com.yin.xiao.dao.impl.OperateDaoImpl;

public class OperateControlImpl implements OperateControl{

	private OperateDao operateDao = new OperateDaoImpl();
	
	@Override
	public boolean insertOperateControl(Operate operate) {
		// TODO Auto-generated method stub
		return operateDao.insertOperateDao(operate);
	}

}
