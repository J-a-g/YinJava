package com.yin.xiao.control.impl;

import java.util.List;

import com.yin.xiao.bean.WeChatInfo;
import com.yin.xiao.control.WeChatInfoControl;
import com.yin.xiao.dao.WeChatInfoDao;
import com.yin.xiao.dao.impl.WeChatInfoDaoImpl;

public class WeChatInfoControlImpl implements WeChatInfoControl{

	private WeChatInfoDao weChatInfoDao = new WeChatInfoDaoImpl(); 
	
	@Override
	public List<WeChatInfo> getWeChatInfos(int index) {
		// TODO Auto-generated method stub
		List<WeChatInfo> list = weChatInfoDao.getWeChatInfo(index);
		if(list.size() > 0) {
			for(WeChatInfo weChatInfo : list) {
				System.out.println("weChatInfo---> " + weChatInfo.toString());
			}
		}else {
			System.out.println("weChatInfo size is 0");
		}
		return list;
	}

}
