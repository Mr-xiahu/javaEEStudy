package com.xiahu.classloader;

public class Demo {
	public static void main(String[] args) {
		// 获得Demo字节码文件对象
		Class clazz = Demo.class;
		// 获得类加载器
		ClassLoader classLoader = clazz.getClassLoader();
		// 获得classes(src)下的任何的资源
		String path = classLoader.getResource("com/xiahu/classloader/jdbc.properties").getPath();
		// classLoader.getResourceAsStream("");
		System.out.println(path);
	}

}
