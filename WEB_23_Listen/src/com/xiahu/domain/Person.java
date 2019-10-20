package com.xiahu.domain;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 钝化与活化的监听器HttpSessionActivationListener
 * 
 * @author Administrator
 *
 */
public class Person implements HttpSessionActivationListener,Serializable {
	private String name;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent event) {
		System.out.println("person已经被活化");

	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent event) {
		System.out.println("person已经被钝化");

	}

}
