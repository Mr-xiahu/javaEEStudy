package com.xiahu.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 绑定与解绑的监听器HttpSessionBindingListener
 * 
 * @author Administrator
 *
 */
public class User implements HttpSessionBindingListener {
	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	// 感知User被绑定到Session
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("User被绑定到Session");
		System.out.println(event.getName());

	}

	@Override
	// 感知User与Session解除绑定(删除)
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("User与Session解除绑定");
	}

}
