package com.yin.xiao.dao;

import java.util.List;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;
import com.yin.xiao.bean.WeChatInfo;

public interface WeChatInfoDao {
	public void insertWeChatUser(WeChatInfo weChatUser);
	
	//index ҳ�룬length��ҳ��ʾ����
	public List<WeChatInfo> getWeChatInfo(int index);
}
