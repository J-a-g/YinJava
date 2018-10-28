package com.yin.xiao.control.impl;

import java.util.List;

import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.dao.WeChatInfoDao;
import com.yin.xiao.dao.impl.WeChatInfoDaoImpl;

public class WeChatInfoControlImpl implements WeChatInfoControl{

	private WeChatInfoDao weChatInfoDao = new WeChatInfoDaoImpl(); 
	
	@Override
	public List<MemberBean> getMemberBean(int index) {
		// TODO Auto-generated method stub
		List<MemberBean> list = weChatInfoDao.getMemberBeansByDelete(index, 0);
		if(list.size() > 0) {
			for(MemberBean memberBean : list) {
				System.out.println("MemberBean---> " + memberBean.toString());
			}
		}else {
			System.out.println("MemberBean size is 0");
		}
		return list;
	}

	@Override
	public List<MemberBean> getMemberBeanBydelete(int index) {
		List<MemberBean> list = weChatInfoDao.getMemberBeansByDelete(index, 1);
		if(list.size() > 0) {
			for(MemberBean memberBean : list) {
				System.out.println("MemberBean---> " + memberBean.toString());
			}
		}else {
			System.out.println("MemberBean size is 0");
		}
		return list;
	}

	@Override
	public List<MemberBean> getBusiness(int index) {
		// TODO Auto-generated method stub
		List<MemberBean> list = weChatInfoDao.getBusinessByDelete(index, 0);
		if(list.size() > 0) {
			for(MemberBean memberBean : list) {
				System.out.println("MemberBean---> " + memberBean.toString());
			}
		}else {
			System.out.println("MemberBean size is 0");
		}
		return list;
	}

	@Override
	public List<MemberBean> getBusinessIsDel(int index) {
		// TODO Auto-generated method stub
		List<MemberBean> list = weChatInfoDao.getBusinessByDelete(index, 1);
		if(list.size() > 0) {
			for(MemberBean memberBean : list) {
				System.out.println("MemberBean---> " + memberBean.toString());
			}
		}else {
			System.out.println("MemberBean size is 0");
		}
		return list;
	}

	@Override
	public List<MemberBean> getBusinessByApplys(int index) {
		// TODO Auto-generated method stub
		List<MemberBean> list = weChatInfoDao.getBusinessByApply(index);
		if(list.size() > 0) {
			for(MemberBean memberBean : list) {
				System.out.println("MemberBean---> " + memberBean.toString());
			}
		}else {
			System.out.println("MemberBean size is 0");
		}
		return list;
	}
}
