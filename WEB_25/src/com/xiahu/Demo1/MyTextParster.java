package com.xiahu.Demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author Administrator
 *
 *         解析注解
 */
public class MyTextParster {
	public static void main(String[] args) throws Exception{
		// 获得使用注解的字节码对象
		Class clazz = AnnoDemo.class;
		// 获得里面的所有方法
		Method[] methods = clazz.getMethods();
		// 判断是否为null
		if (methods != null) {
			// 遍历
			for (Method method : methods) {
				// 判断该方法是否使用了@MyTest注解
				boolean annotationPresent = method.isAnnotationPresent(MyTest.class);
				if (annotationPresent) {
					// 使用了@MyTest注解,执行该方法
					method.invoke(clazz.newInstance(), null);
				}
			}
		}
	}

}
