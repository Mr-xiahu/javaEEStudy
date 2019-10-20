package com.xiahu.attributelistener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 监听servlet域的属性在发生变化
 * @author Administrator
 *
 */
public class MyServletContextAttributeListener implements ServletContextAttributeListener {

	@Override
	public void attributeAdded(ServletContextAttributeEvent sc) {
		// 添加属性的key
		System.out.println(sc.getName());
		// 添加属性的value
		System.out.println(sc.getValue());

	}

	@Override
	public void attributeRemoved(ServletContextAttributeEvent sc) {
		// 删除该属性时的key值
		System.out.println(sc.getName());
		// 删除该属性时的value值
		System.out.println(sc.getValue());

	}

	@Override
	public void attributeReplaced(ServletContextAttributeEvent sc) {
		// 替换前的key值
		System.out.println(sc.getName());
		//替换前的value值
		System.out.println(sc.getValue());

	}

}
