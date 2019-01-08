package com.yin.xiao;

public class Operate {
	private Integer operateId;
	private String machineSn;
	private String createTime;
	private Integer type;
	private String mark;

	@Override
	public String toString() {
		return "Operate [operateId=" + operateId + ", machineSn=" + machineSn + ", createTime=" + createTime + ", type="
				+ type + ", mark=" + mark + "]";
	}

	public Integer getOperateId() {
		return operateId;
	}

	public void setOperateId(Integer operateId) {
		this.operateId = operateId;
	}

	public String getMachineSn() {
		return machineSn;
	}

	public void setMachineSn(String machineSn) {
		this.machineSn = machineSn;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}
