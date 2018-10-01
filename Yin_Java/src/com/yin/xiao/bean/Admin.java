package com.yin.xiao.bean;

public class Admin {
	private Integer admin_uid;
	private String admin_username;
	private String admin_pwd;
	private String power;
	private String email;
	private String create_time;
	private String phone_number;
	private int delete;
	private int status;

	@Override
	public String toString() {
		return "Admin [admin_uid=" + admin_uid + ", admin_username=" + admin_username + ", admin_pwd=" + admin_pwd
				+ ", power=" + power + ", email=" + email + ", create_time=" + create_time + ", phone_number="
				+ phone_number + ", delete=" + delete + ", status=" + status + "]";
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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
