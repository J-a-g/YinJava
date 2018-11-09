package com.yin.xiao.bean;

public class Orderlist_Html_Bean {
	private int orderId;
	private String order_sn;
	private String mark;
	private float order_price;
	private int order_status;
	private int pay_status;
	private int pay_type;
	private String str_order_status;
	private String str_pay_status;
	private String str_pay_type;
	private String create_time;
	private String user_nickName;
	private String business_nickName;
	private String kitchenName;

	@Override
	public String toString() {
		return "Orderlist_Html_Bean [orderId=" + orderId + ", order_sn=" + order_sn + ", mark=" + mark
				+ ", order_price=" + order_price + ", order_status=" + order_status + ", pay_status=" + pay_status
				+ ", pay_type=" + pay_type + ", str_order_status=" + str_order_status + ", str_pay_status="
				+ str_pay_status + ", str_pay_type=" + str_pay_type + ", create_time=" + create_time
				+ ", user_nickName=" + user_nickName + ", business_nickName=" + business_nickName + ", kitchenName="
				+ kitchenName + "]";
	}

	public String getStr_order_status() {
		return str_order_status;
	}

	public void setStr_order_status(String str_order_status) {
		this.str_order_status = str_order_status;
	}

	public String getStr_pay_status() {
		return str_pay_status;
	}

	public void setStr_pay_status(String str_pay_status) {
		this.str_pay_status = str_pay_status;
	}

	public String getStr_pay_type() {
		return str_pay_type;
	}

	public void setStr_pay_type(String str_pay_type) {
		this.str_pay_type = str_pay_type;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrder_sn() {
		return order_sn;
	}

	public void setOrder_sn(String order_sn) {
		this.order_sn = order_sn;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public float getOrder_price() {
		return order_price;
	}

	public void setOrder_price(float order_price) {
		this.order_price = order_price;
	}

	public int getOrder_status() {
		return order_status;
	}

	public void setOrder_status(int order_status) {
		this.order_status = order_status;
	}

	public int getPay_status() {
		return pay_status;
	}

	public void setPay_status(int pay_status) {
		this.pay_status = pay_status;
	}

	public int getPay_type() {
		return pay_type;
	}

	public void setPay_type(int pay_type) {
		this.pay_type = pay_type;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getUser_nickName() {
		return user_nickName;
	}

	public void setUser_nickName(String user_nickName) {
		this.user_nickName = user_nickName;
	}

	public String getBusiness_nickName() {
		return business_nickName;
	}

	public void setBusiness_nickName(String business_nickName) {
		this.business_nickName = business_nickName;
	}

	public String getKitchenName() {
		return kitchenName;
	}

	public void setKitchenName(String kitchenName) {
		this.kitchenName = kitchenName;
	}

}
