package com.yin.xiao.dao;

import com.sun.tracing.dtrace.ProviderAttributes;

public interface AdminDao {
	public boolean login(String admin_username, String admin_pwd);
}
