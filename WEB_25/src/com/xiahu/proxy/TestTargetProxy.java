package com.xiahu.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.junit.Test;

public class TestTargetProxy {

	@Test
	public void test() {
		// 获得动态的代理对象----在运行时 在内存中动态的为Target创建一个虚拟的代理对象
		TargetImplements obj = (TargetImplements) Proxy.newProxyInstance(TargetDemo.class.getClassLoader(), // 与目标对象相同的类加载器
				new Class[] { TargetImplements.class }, // 字节码对象的接口集合
				new InvocationHandler() {
					/**
					 * invoke:代表执行代理对象的方法 method:代表目标对象的方法字节码对象
					 * args:代表目标对象的响应的方法的参数
					 */
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						Object invoke = method.invoke(new TargetDemo(), args);
						return invoke;
					}
				});

		obj.show();
		String method = obj.method();
		System.out.println(method);
		int age = obj.age(30);
		System.out.println(age);
	}

}
