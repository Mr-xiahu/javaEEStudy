package com.xiahu.domain;

/**
 * 这是条件查询的实体类
 * @author Administrator
 *
 */
public class Condition {
	private String pname;
	private String isHot;
	private String cid;

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getIsHot() {
		return isHot;
	}

	public void setIsHot(String isHot) {
		this.isHot = isHot;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
