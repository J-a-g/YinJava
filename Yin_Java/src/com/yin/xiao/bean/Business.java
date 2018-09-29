package com.yin.xiao.bean;

public class Business {

	private Integer businessId;
	private int age;
	private String phone_number;
	private String address;
	private int status;
	private int type;
	private Integer integral;
	private Integer complain_num;
	private Integer comment_num;
	private Integer shopping_num;
	private String name;
	private String id_card_url_1;
	private String id_card_url_2;
	private Integer kitchenId;
	private String create_time;
	private int delete;

	@Override
	public String toString() {
		return "Business [businessId=" + businessId + ", age=" + age + ", phone_number=" + phone_number + ", address="
				+ address + ", status=" + status + ", type=" + type + ", integral=" + integral + ", complain_num="
				+ complain_num + ", comment_num=" + comment_num + ", shopping_num=" + shopping_num + ", name=" + name
				+ ", id_card_url_1=" + id_card_url_1 + ", id_card_url_2=" + id_card_url_2 + ", kitchenId=" + kitchenId
				+ ", create_time=" + create_time + ", delete=" + delete + "]";
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	public Integer getComment_num() {
		return comment_num;
	}

	public void setComment_num(Integer comment_num) {
		this.comment_num = comment_num;
	}

	public Integer getShopping_num() {
		return shopping_num;
	}

	public void setShopping_num(Integer shopping_num) {
		this.shopping_num = shopping_num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_card_url_1() {
		return id_card_url_1;
	}

	public void setId_card_url_1(String id_card_url_1) {
		this.id_card_url_1 = id_card_url_1;
	}

	public String getId_card_url_2() {
		return id_card_url_2;
	}

	public void setId_card_url_2(String id_card_url_2) {
		this.id_card_url_2 = id_card_url_2;
	}

	public Integer getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(Integer kitchenId) {
		this.kitchenId = kitchenId;
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
