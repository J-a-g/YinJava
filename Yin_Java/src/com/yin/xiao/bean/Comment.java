package com.yin.xiao.bean;

import javax.lang.model.type.PrimitiveType;

public class Comment {
	private Integer commentId;
	private String comment_content;
	private String create_time;
	private int delete;
	private Integer wechat_uid;
	private Integer goodsId;
	private Integer kitchenId;

	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment_content=" + comment_content + ", create_time="
				+ create_time + ", delete=" + delete + ", wechat_uid=" + wechat_uid + ", goodsId=" + goodsId
				+ ", kitchenId=" + kitchenId + "]";
	}

	public Integer getCommentId() {
		return commentId;
	}

	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}

	public String getComment_content() {
		return comment_content;
	}

	public void setComment_content(String comment_content) {
		this.comment_content = comment_content;
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

	public Integer getWechat_uid() {
		return wechat_uid;
	}

	public void setWechat_uid(Integer wechat_uid) {
		this.wechat_uid = wechat_uid;
	}

	public Integer getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Integer getKitchenId() {
		return kitchenId;
	}

	public void setKitchenId(Integer kitchenId) {
		this.kitchenId = kitchenId;
	}

}
