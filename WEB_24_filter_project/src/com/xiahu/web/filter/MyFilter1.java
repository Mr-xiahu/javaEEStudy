package com.xiahu.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyFilter1 implements Filter {

	@Override
	// Filter创建的时候执行init方法
	// 该方法在服务器启动时创建
	public void init(FilterConfig init) {
		// 1.获取该getServletContext对象
		ServletContext context = init.getServletContext();
		// 2.获得web.xml中filter 的名称<filter-name>MyFilterDemo</filter-name>
		System.out.println(init.getFilterName());
		// 3.获取web.xml中的初始化配置参数
		System.out.println(init.getInitParameter("aaaa"));

		System.out.println("init   running.....");

	}

	@Override
	// Filter的核心过滤方法
	/*
	 * request: 内部封装是客户端http请求的内容 response: 代表是响应 FilterChain: 过滤器链对象
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("MyFilterDemo1 running.....");
		// 放行请求
		chain.doFilter(request, response);

	}

	@Override
	//// Filter销毁的时候执行destroy方法
	// 该方法在服务器关闭时被调用
	public void destroy() {
		System.out.println("已经销毁");
	}

}
