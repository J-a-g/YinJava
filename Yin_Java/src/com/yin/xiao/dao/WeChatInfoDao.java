package com.yin.xiao.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.sun.prism.Mesh;
import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.bean.WeChatInfo;

public interface WeChatInfoDao {
	public void insertWeChatUser(WeChatInfo weChatUser);
	
	public List<MemberBean> getMemberBeansByDelete(int index, int del);

	public List<MemberBean> getBusinessByDelete(int index, int del);
	
	/**
	 * ��ҳ��ȡ�ύ��˵��̻���Ϣ
	 * @param index
	 * @return
	 */
	public List<MemberBean> getBusinessByApply(int index);
}
