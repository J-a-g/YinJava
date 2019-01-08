package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yin.xiao.Operate;
import com.yin.xiao.dao.OperateDao;
import com.yin.xiao.util.DBUtil;

public class OperateDaoImpl implements OperateDao{
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");

	@Override
	public boolean insertOperateDao(Operate operate) {
		// TODO Auto-generated method stub
		//insert into operate(machine_sn, create_time, type, mark) value('9999999', '789', '0', 'pspsps')
				Connection conn = null;
				boolean tmp = false;
				try {
					conn = DBUtil.getConnection();
					String sql = "insert into operate(machine_sn, create_time, type, mark, create_time_2) value('" +
					operate.getMachineSn() + "', '"+ System.currentTimeMillis() +"',"
							+ " '" + operate.getType() + "', '" + operate.getMark() + "', '" + sdf.format(new Date()) + "')";
					PreparedStatement ps = conn.prepareStatement(sql);
					int flg = ps.executeUpdate(sql);// ÷¥––sql”Ôæ‰
					if (flg == 1) {
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
