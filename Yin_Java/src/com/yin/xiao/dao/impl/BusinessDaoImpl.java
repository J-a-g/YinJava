package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yin.xiao.dao.BusinessDao;
import com.yin.xiao.util.DBUtil;

public class BusinessDaoImpl implements BusinessDao {

	@Override
	public boolean recoverBusiness(int businessId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update business set del = 0 where businessId = " + businessId;
			PreparedStatement ps = conn.prepareStatement(sql);
			int flag = ps.executeUpdate(sql);// ÷¥––sql”Ôæ‰
			if (flag == 1) {
				tmp = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return tmp;
	}

	@Override
	public boolean delBusiness(int businessId) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update business set del = 1, status = 2 where businessId = " + businessId;
			PreparedStatement ps = conn.prepareStatement(sql);
			int flag = ps.executeUpdate(sql);// ÷¥––sql”Ôæ‰
			if (flag == 1) {
				tmp = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return tmp;
	}

	@Override
	public boolean updateBusinessStatus(int businessId, int status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update business set status = " + status + " where businessId = " + businessId;
			PreparedStatement ps = conn.prepareStatement(sql);
			int flag = ps.executeUpdate(sql);// ÷¥––sql”Ôæ‰
			if (flag == 1) {
				tmp = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return tmp;
	}
}
