package com.yin.xiao.control;

import java.util.List;

import com.yin.xiao.bean.MemberBean;

public interface WeChatInfoControl{
	public List<MemberBean> getMemberBean(int index);
	
	public List<MemberBean> getMemberBeanBydelete(int index);
	
	public List<MemberBean> getBusiness(int index);
	
	public List<MemberBean> getBusinessIsDel(int index);
	
	public List<MemberBean> getBusinessByApplys(int index);
}
