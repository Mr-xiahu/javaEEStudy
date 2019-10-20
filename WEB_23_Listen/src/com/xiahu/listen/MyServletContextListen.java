package com.xiahu.listen;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListen implements ServletContextListener {

	@Override
	// 监听servletContext的创建
	public void contextInitialized(ServletContextEvent ser) {

		// 1.获取servletContext对象
		// ServletContext servletContext = ser.getServletContext();

		// 2.获得源
		// Object source = ser.getSource();

		System.out.println("MyServletContextListen已经启动");

		// 3.时间调度(定时器)
		// Timer timer = new Timer();
		// task:执行的任务
		// firstTime:第一次执行的时间
		// period:间隔时间
		// timer.scheduleAtFixedRate(new TimerTask() {
		//
		// @Override
		// public void run() {
		// //System.out.println("定时器任务开始---------");
		//
		//
		// }
		// }, new Date(), 3000);

		// 修改定时器时间,启动时间为晚上12点
		Timer timer = new Timer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date parse = null;
		try {
			parse = sdf.parse("2018-7-26 10:45:00");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.println("定时器任务开始---------");

			}
		}, parse, 24 * 60 * 60 * 1000);

	}

	@Override
	// 监听servletContext的销毁
	public void contextDestroyed(ServletContextEvent ser) {
		System.out.println("MyServletContextListen已经销毁");
	}
}
