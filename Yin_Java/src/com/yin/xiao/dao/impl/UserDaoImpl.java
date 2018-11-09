package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.yin.xiao.dao.UserDao;
import com.yin.xiao.util.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean delUser(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update user set del = 1, status = 2 where uid = " + uid;
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
	public boolean updateUserStatus(int uid, int status) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update user set status = " + status + " where uid = " + uid;
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
	public boolean recoverUser(int uid) {
		// TODO Auto-generated method stub
		Connection conn = null;
		boolean tmp = false;
		try {
			conn = DBUtil.getConnection();
			String sql = "update user set del = 0 where uid = " + uid;
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
