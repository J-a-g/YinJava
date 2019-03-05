package com.yin.xiao;

public class TestBean {

	private int id;
	private String reString;
	
	
	@Override
	public String toString() {
		return "TestBean [id=" + id + ", reString=" + reString + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReString() {
		return reString;
	}
	public void setReString(String reString) {
		this.reString = reString;
	}
	
	
}
