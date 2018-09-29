package com.yin.xiao.bean;

public class Goods {
	private Integer goodsId;
	private String goods_name;
	private float goods_price;
	private String goods_desc;
	private String goods_img_1;
	private String goods_img_2;
	private String goods_img_3;
	private Integer day_max;
	private Integer day_surplus;
	private String create_time;
	private int delete;
	private String goods_detail_desc;

	@Override
	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goods_name=" + goods_name + ", goods_price=" + goods_price
				+ ", goods_desc=" + goods_desc + ", goods_img_1=" + goods_img_1 + ", goods_img_2=" + goods_img_2
				+ ", goods_img_3=" + goods_img_3 + ", day_max=" + day_max + ", day_surplus=" + day_surplus
				+ ", create_time=" + create_time + ", delete=" + delete + ", goods_detail_desc=" + goods_detail_desc
				+ "]";
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public float getGoods_price() {
		return goods_price;
	}

	public void setGoods_price(float goods_price) {
		this.goods_price = goods_price;
	}

	public String getGoods_desc() {
		return goods_desc;
	}

	public void setGoods_desc(String goods_desc) {
		this.goods_desc = goods_desc;
	}

	public String getGoods_img_1() {
		return goods_img_1;
	}

	public void setGoods_img_1(String goods_img_1) {
		this.goods_img_1 = goods_img_1;
	}

	public String getGoods_img_2() {
		return goods_img_2;
	}

	public void setGoods_img_2(String goods_img_2) {
		this.goods_img_2 = goods_img_2;
	}

	public String getGoods_img_3() {
		return goods_img_3;
	}

	public void setGoods_img_3(String goods_img_3) {
		this.goods_img_3 = goods_img_3;
	}

	public Integer getDay_max() {
		return day_max;
	}

	public void setDay_max(Integer day_max) {
		this.day_max = day_max;
	}

	public Integer getDay_surplus() {
		return day_surplus;
	}

	public void setDay_surplus(Integer day_surplus) {
		this.day_surplus = day_surplus;
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

	public String getGoods_detail_desc() {
		return goods_detail_desc;
	}

	public void setGoods_detail_desc(String goods_detail_desc) {
		this.goods_detail_desc = goods_detail_desc;
	}

}
