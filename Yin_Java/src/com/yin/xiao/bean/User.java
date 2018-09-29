package com.yin.xiao.bean;

import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import com.sun.tracing.dtrace.ProviderAttributes;

public class User {

	private Integer uid;
	private Integer age;
	private String phone_number;
	private String address;
	private int status;
	private Integer integral;
	private Integer complain_num;
	private Integer shopping_num;
	private Integer comment_num;
	private String name;
	private String create_time;
	private int delete;

	@Override
	public String toString() {
		return "User [uid=" + uid + ", age=" + age + ", phone_number=" + phone_number + ", address=" + address
				+ ", status=" + status + ", integral=" + integral + ", complain_num=" + complain_num + ", shopping_num="
				+ shopping_num + ", comment_num=" + comment_num + ", name=" + name + ", create_time=" + create_time
				+ ", delete=" + delete + "]";
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Integer getIntegral() {
		return integral;
	}

	public void setIntegral(Integer integral) {
		this.integral = integral;
	}

	public Integer getComplain_num() {
		return complain_num;
	}

	public void setComplain_num(Integer complain_num) {
		this.complain_num = complain_num;
	}

	public Integer getShopping_num() {
		return shopping_num;
	}

	public void setShopping_num(Integer shopping_num) {
		this.shopping_num = shopping_num;
	}

	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
