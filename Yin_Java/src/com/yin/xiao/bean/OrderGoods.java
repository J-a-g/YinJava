package com.yin.xiao.bean;

public class OrderGoods {
	private Integer order_goods_id;
	private Integer orderId;
	private Integer goodsId;
	private Integer num;

	@Override
	public String toString() {
		return "OrderGoods [order_goods_id=" + order_goods_id + ", orderId=" + orderId + ", goodsId=" + goodsId
				+ ", num=" + num + "]";
	}

	public Integer getOrder_goods_id() {
		return order_goods_id;
	}

	public void setOrder_goods_id(Integer order_goods_id) {
		this.order_goods_id = order_goods_id;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

}
