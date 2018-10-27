package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yin.xiao.bean.WeChatInfo;
import com.yin.xiao.dao.WeChatInfoDao;
import com.yin.xiao.util.DBUtil;

import javafx.scene.shape.Arc;

public class WeChatInfoDaoImpl implements WeChatInfoDao {

	@Override
	public void insertWeChatUser(WeChatInfo weChatUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<WeChatInfo> getWeChatInfo(int index) {
		// TODO Auto-generated method stub
		int length = 10;
		int start = index * length;
		List<WeChatInfo> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			// select * from wechat_info ORDER BY wechat_uid asc limit 1, 10
			String sql = "select * from wechat_info where uid is not NULL ORDER BY wechat_uid asc limit " + start + ", "
					+ length;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// 结果集(rs)的结构信息，比如字段数、字段名等。
			// int columnCount = md.getColumnCount();// 取得查询出来的字段个数
			while (rs.next()) {// 迭代rs
				WeChatInfo weChatInfo = new WeChatInfo();
				weChatInfo.setAvatarUrl(rs.getString("avatarUrl"));
				weChatInfo.setBusinessId(rs.getInt("businessId"));
				weChatInfo.setCity(rs.getString("city"));
				weChatInfo.setCountry(rs.getString("country"));
				weChatInfo.setGender(rs.getInt("gender"));
				weChatInfo.setLanguage(rs.getString("language"));
				weChatInfo.setNickName(rs.getString("nickName"));
				weChatInfo.setProvince(rs.getString("province"));
				weChatInfo.setSignature(rs.getString("signature"));
				weChatInfo.setUid(rs.getInt("uid"));
				weChatInfo.setWechat_uid(rs.getInt("wechat_uid"));
				list.add(weChatInfo);
			}
			DBUtil.close(conn);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
