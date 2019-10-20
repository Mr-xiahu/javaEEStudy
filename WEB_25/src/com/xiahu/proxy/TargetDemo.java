package com.xiahu.proxy;

public class TargetDemo implements TargetImplements{

	@Override
	public void show() {
		System.out.println("我是一只小小小小鸟");
		
	}

	@Override
	public String method() {
		
		return "hello proxy";
	}

	@Override
	public int age(int x) {
		
		return x;
	}

}
