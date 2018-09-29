package com.yin.xiao.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;

public class DBUtil {
	// �������ӳ�
    private static BasicDataSource ds;

    static {
        // ��ȡ���Ӳ���
        Properties p = new Properties();
        try {
            p.load(DBUtil.class.getClassLoader().getResourceAsStream("database.properties"));
            // ���ݿ����Ӳ���
            String driver = p.getProperty("driver");
            String url = p.getProperty("url");
            String user = p.getProperty("user");
            String pwd = p.getProperty("pwd");
            // ���ӳز���
            String initSize = p.getProperty("initSize");
            String maxSize = p.getProperty("maxSize");
            // �������ӳ�,���������ò���
            ds = new BasicDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(pwd);
            ds.setInitialSize(Integer.parseInt(initSize));
            ds.setMaxTotal(Integer.parseInt(maxSize));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("�Ҳ����ļ�", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * �黹����: ���ӳش���������,��close���������� �ر�����,���ǽ����ӹ黹�����ӳ�, ���ӳػὫ������������ղ���ʶΪ����.
     */
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("�黹����ʧ��", e);
            }
        }
    }

    public static void main(String[] args) throws SQLException {
        System.out.println(getConnection());
    }

}
