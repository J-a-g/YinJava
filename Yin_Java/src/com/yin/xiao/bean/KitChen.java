package com.yin.xiao.bean;

public class KitChen {
	private Integer kitchenId;
	private Integer businessId;
	private int statut;
	private String kitchen_url_1;
	private String kitchen_url_2;
	private String kitchen_url_3;
	private Integer goodsId_1;
	private Integer goodsId_2;
	private Integer goodsId_3;
	private Integer goodsId_4;
	private Integer goodsId_5;
	private int service_time;
	private int order_num;
	private int service_distance;
	private String longitude;
	private String latitude;
	private String create_time;
	private int delete;
	private int goods_num;

	@Override
	public String toString() {
		return "KitChen [kitchenId=" + kitchenId + ", businessId=" + businessId + ", statut=" + statut
				+ ", kitchen_url_1=" + kitchen_url_1 + ", kitchen_url_2=" + kitchen_url_2 + ", kitchen_url_3="
				+ kitchen_url_3 + ", goodsId_1=" + goodsId_1 + ", goodsId_2=" + goodsId_2 + ", goodsId_3=" + goodsId_3
				+ ", goodsId_4=" + goodsId_4 + ", goodsId_5=" + goodsId_5 + ", service_time=" + service_time
				+ ", order_num=" + order_num + ", service_distance=" + service_distance + ", longitude=" + longitude
				+ ", latitude=" + latitude + ", create_time=" + create_time + ", delete=" + delete + ", goods_num="
				+ goods_num + "]";
	}

	public Integer getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(Integer kitchenId) {
		this.kitchenId = kitchenId;
	}

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public int getStatut() {
		return statut;
	}

	public void setStatut(int statut) {
		this.statut = statut;
	}

	public String getKitchen_url_1() {
		return kitchen_url_1;
	}

	public void setKitchen_url_1(String kitchen_url_1) {
		this.kitchen_url_1 = kitchen_url_1;
	}

	public String getKitchen_url_2() {
		return kitchen_url_2;
	}

	public void setKitchen_url_2(String kitchen_url_2) {
		this.kitchen_url_2 = kitchen_url_2;
	}

	public String getKitchen_url_3() {
		return kitchen_url_3;
	}

	public void setKitchen_url_3(String kitchen_url_3) {
		this.kitchen_url_3 = kitchen_url_3;
	}

	public Integer getGoodsId_1() {
		return goodsId_1;
	}

	public void setGoodsId_1(Integer goodsId_1) {
		this.goodsId_1 = goodsId_1;
	}

	public Integer getGoodsId_2() {
		return goodsId_2;
	}

	public void setGoodsId_2(Integer goodsId_2) {
		this.goodsId_2 = goodsId_2;
	}

	public Integer getGoodsId_3() {
		return goodsId_3;
	}

	public void setGoodsId_3(Integer goodsId_3) {
		this.goodsId_3 = goodsId_3;
	}

	public Integer getGoodsId_4() {
		return goodsId_4;
	}

	public void setGoodsId_4(Integer goodsId_4) {
		this.goodsId_4 = goodsId_4;
	}

	public Integer getGoodsId_5() {
		return goodsId_5;
	}

	public void setGoodsId_5(Integer goodsId_5) {
		this.goodsId_5 = goodsId_5;
	}

	public int getService_time() {
		return service_time;
	}

	public void setService_time(int service_time) {
		this.service_time = service_time;
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public int getService_distance() {
		return service_distance;
	}

	public void setService_distance(int service_distance) {
		this.service_distance = service_distance;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
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

	public int getGoods_num() {
		return goods_num;
	}

	public void setGoods_num(int goods_num) {
		this.goods_num = goods_num;
	}
}
