package com.yin.xiao.bean;

public class Order {
	private Integer orderId;
	private String mark;
	private String create_time;
	private String complete_time;
	private String close_time;
	private int delete;
	private float order_price;
	private Integer wechat_uid;
	private Integer kitchenId;
	private int status;
	private int pay_status;
	private int pay_type;

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", mark=" + mark + ", create_time=" + create_time + ", complete_time="
				+ complete_time + ", close_time=" + close_time + ", delete=" + delete + ", order_price=" + order_price
				+ ", wechat_uid=" + wechat_uid + ", kitchenId=" + kitchenId + ", status=" + status + ", pay_status="
				+ pay_status + ", pay_type=" + pay_type + "]";
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	public String getComplete_time() {
		return complete_time;
	}

	public void setComplete_time(String complete_time) {
		this.complete_time = complete_time;
	}

	public String getClose_time() {
		return close_time;
	}

	public void setClose_time(String close_time) {
		this.close_time = close_time;
	}

	public int getDelete() {
		return delete;
	}

	public void setDelete(int delete) {
		this.delete = delete;
	}

	public float getOrder_price() {
		return order_price;
	}

	public void setOrder_price(float order_price) {
		this.order_price = order_price;
	}

	public Integer getWechat_uid() {
		return wechat_uid;
	}

	public void setWechat_uid(Integer wechat_uid) {
		this.wechat_uid = wechat_uid;
	}

	public Integer getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(Integer kitchenId) {
		this.kitchenId = kitchenId;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
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

}
