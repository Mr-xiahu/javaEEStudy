package com.xiahu.datebase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestDemo {
	public static void main(String[] args) {
		System.out.println("hello JUnit!");
	}
	
	@Test
	public void TestJUnit(){
		System.out.println("Hello JUnit!");
	}
	
	@Before
	public void TestBefore(){
		System.out.println("brfore");
	}
	
	@After
	public void TestAfter(){
		System.out.println("after");
	}

}
