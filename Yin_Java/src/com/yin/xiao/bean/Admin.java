package com.yin.xiao.bean;

public class Admin {
	private Integer admin_uid;
	private String admin_username;
	private String admin_pwd;
	private String power;
	
	
	@Override
	public String toString() {
		return "Admin [admin_uid=" + admin_uid + ", admin_username=" + admin_username + ", admin_pwd=" + admin_pwd
				+ ", power=" + power + "]";
	}
	public Integer getAdmin_uid() {
		return admin_uid;
	}
	public void setAdmin_uid(Integer admin_uid) {
		this.admin_uid = admin_uid;
	}
	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}
	public String getAdmin_pwd() {
		return admin_pwd;
	}
	public void setAdmin_pwd(String admin_pwd) {
		this.admin_pwd = admin_pwd;
	}
	public String getPower() {
		return power;
	}
	public void setPower(String power) {
		this.power = power;
	}
}
