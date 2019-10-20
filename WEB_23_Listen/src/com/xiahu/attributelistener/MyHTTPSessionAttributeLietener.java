package com.xiahu.attributelistener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class MyHTTPSessionAttributeLietener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent sc) {
		// 添加属性的key
		System.out.println(sc.getName());
		// 添加属性的value
		System.out.println(sc.getValue());

	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent sc) {
		// 删除该属性时的key值
		System.out.println(sc.getName());
		// 删除该属性时的value值
		System.out.println(sc.getValue());

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent sc) {
		// 替换前的key值
		System.out.println(sc.getName());
		// 替换前的value值
		System.out.println(sc.getValue());

	}

}
