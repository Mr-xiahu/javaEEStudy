package com.xiahu.Demo1;

import org.junit.Test;

/**
 * @author Administrator
 *注解自己使用的步骤:
 *   1.
 *   2.
 *   3.解析注解
 *
 */
public class AnnoDemo {
	
	//@Test自带的注解,现在我要使用自己的写的注解
	
	@MyTest
	public void show(){
		System.out.println("夏虎是真滴帅");
	}

}
