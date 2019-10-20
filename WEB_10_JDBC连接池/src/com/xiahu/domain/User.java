package com.xiahu.domain;

/**
 * @author Administrator
 *
 */
public class User {
	private int uId;
	private String uName;
	private String uPassword;
	private String uAge;
	
	public User() {
		super();
	}
	
	public User(int uId, String uName, String uPassword, String uAge) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uAge = uAge;
	}
	
	public int getuId() {
		return uId;
	}
	
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	public String getuName() {
		return uName;
	}
	
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getuPassword() {
		return uPassword;
	}
	
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	
	public String getuAge() {
		return uAge;
	}
	
	public void setuAge(String uAge) {
		this.uAge = uAge;
	}
	
	

}
