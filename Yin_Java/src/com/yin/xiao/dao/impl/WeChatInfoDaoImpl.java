package com.yin.xiao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.yin.xiao.bean.MemberBean;
import com.yin.xiao.bean.WeChatInfo;
import com.yin.xiao.dao.WeChatInfoDao;
import com.yin.xiao.util.DBUtil;

import javafx.scene.shape.Arc;
import sun.security.util.Length;

public class WeChatInfoDaoImpl implements WeChatInfoDao {

	private int length = 10;

	@Override
	public void insertWeChatUser(WeChatInfo weChatUser) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<MemberBean> getMemberBeansByDelete(int index, int del) {
		// TODO Auto-generated method stub
		int start = index * length;
		List<MemberBean> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select wechat_uid, w.uid, w.businessId,nickName, gender, country,province,"
					+ " city, signature, phone_number, address, del, create_time, status from wechat_info w, "
					+ "user u where w.uid=u.uid && u.del = " + del + " ORDER BY wechat_uid asc limit " + start + ", "
					+ length;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// �����(rs)�Ľṹ��Ϣ�������ֶ������ֶ����ȡ�
			// int columnCount = md.getColumnCount();// ȡ�ò�ѯ�������ֶθ���
			while (rs.next()) {// ����rs
				MemberBean memberBean = new MemberBean();
				memberBean.setAddress(rs.getString("address"));
				memberBean.setBusinessId(rs.getInt("businessId"));
				memberBean.setCountry(rs.getString("country"));
				memberBean.setCreate_time(rs.getString("create_time"));
				if (rs.getString("gender").equals("1")) {
					memberBean.setGender("��");
				} else {
					memberBean.setGender("Ů");
				}
				if (rs.getInt("status") == 0) {
					memberBean.setStatus("����");
				} else if (rs.getInt("status") == 1) {
					memberBean.setStatus("�û�ע��");
				} else if (rs.getInt("status") == 2) {
					memberBean.setStatus("������Աͣ��");
				}
				memberBean.setNickName(rs.getString("nickName"));
				memberBean.setPhone_number(rs.getString("phone_number"));
				memberBean.setProvince(rs.getString("province"));
				memberBean.setSignature(rs.getString("signature"));
				memberBean.setUid(rs.getInt("uid"));
				memberBean.setCity(rs.getString("city"));
				memberBean.setWechat_uid(rs.getInt("wechat_uid"));
				list.add(memberBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<MemberBean> getBusinessByDelete(int index, int del) {
		int start = index * length;
		List<MemberBean> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select wechat_uid, w.uid, w.businessId,nickName, gender, country,province,"
					+ " city, signature, phone_number, address, del, create_time, status from wechat_info w, "
					+ "business b where w.businessId = b.businessId && b.del = " + del + " && b.status != 3"
							+ " ORDER BY wechat_uid asc limit " + start + ", " + length;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// �����(rs)�Ľṹ��Ϣ�������ֶ������ֶ����ȡ�
			// int columnCount = md.getColumnCount();// ȡ�ò�ѯ�������ֶθ���
			while (rs.next()) {// ����rs
				MemberBean memberBean = new MemberBean();
				memberBean.setAddress(rs.getString("address"));
				memberBean.setBusinessId(rs.getInt("businessId"));
				memberBean.setCountry(rs.getString("country"));
				memberBean.setCreate_time(rs.getString("create_time"));
				if (rs.getString("gender").equals("1")) {
					memberBean.setGender("��");
				} else {
					memberBean.setGender("Ů");
				}
				if (rs.getInt("status") == 0) {
					memberBean.setStatus("����");
				} else if (rs.getInt("status") == 1) {
					memberBean.setStatus("�û�ע��");
				} else if (rs.getInt("status") == 2) {
					memberBean.setStatus("������Աͣ��");
				}
				memberBean.setNickName(rs.getString("nickName"));
				memberBean.setPhone_number(rs.getString("phone_number"));
				memberBean.setProvince(rs.getString("province"));
				memberBean.setSignature(rs.getString("signature"));
				memberBean.setUid(rs.getInt("uid"));
				memberBean.setCity(rs.getString("city"));
				memberBean.setWechat_uid(rs.getInt("wechat_uid"));
				list.add(memberBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}

	@Override
	public List<MemberBean> getBusinessByApply(int index) {
		int start = index * length;
		List<MemberBean> list = new ArrayList<>();
		Connection conn = null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select wechat_uid, w.uid, w.businessId,nickName, gender, country,province,"
					+ " city, signature, phone_number, address, del, create_time, status from wechat_info w, "
					+ "business b where w.businessId = b.businessId && b.del = 0 && b.status = 3"
							+ " ORDER BY wechat_uid asc limit " + start + ", " + length;
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			// ResultSetMetaData md = rs.getMetaData();// �����(rs)�Ľṹ��Ϣ�������ֶ������ֶ����ȡ�
			// int columnCount = md.getColumnCount();// ȡ�ò�ѯ�������ֶθ���
			while (rs.next()) {// ����rs
				MemberBean memberBean = new MemberBean();
				memberBean.setAddress(rs.getString("address"));
				memberBean.setBusinessId(rs.getInt("businessId"));
				memberBean.setCountry(rs.getString("country"));
				memberBean.setCreate_time(rs.getString("create_time"));
				if (rs.getString("gender").equals("1")) {
					memberBean.setGender("��");
				} else {
					memberBean.setGender("Ů");
				}
				if (rs.getInt("status") == 0) {
					memberBean.setStatus("����");
				} else if (rs.getInt("status") == 1) {
					memberBean.setStatus("�û�ע��");
				} else if (rs.getInt("status") == 2) {
					memberBean.setStatus("������Աͣ��");
				}else if(rs.getInt("status") == 3) {
					memberBean.setStatus("�����");
				}
				memberBean.setNickName(rs.getString("nickName"));
				memberBean.setPhone_number(rs.getString("phone_number"));
				memberBean.setProvince(rs.getString("province"));
				memberBean.setSignature(rs.getString("signature"));
				memberBean.setUid(rs.getInt("uid"));
				memberBean.setCity(rs.getString("city"));
				memberBean.setWechat_uid(rs.getInt("wechat_uid"));
				list.add(memberBean);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			DBUtil.close(conn);
		}
		return list;
	}
}
