package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.yin.xiao.dao.AdminDao;
import com.yin.xiao.util.DBUtil;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean login(String admin_username, String admin_pwd) {
		// TODO Auto-generated method stub
		boolean tmp = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from admin where admin_username='" + admin_username + "' && admin_pwd='" + admin_pwd
					+ "'";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// �����(rs)�Ľṹ��Ϣ�������ֶ������ֶ����ȡ�
			// int columnCount = md.getColumnCount();// ȡ�ò�ѯ�������ֶθ���
			while (rs.next()) {// ����rs
				tmp = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DBUtil.close(conn);
		}
		return tmp;
	}

}
