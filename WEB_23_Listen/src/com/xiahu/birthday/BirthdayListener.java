package com.xiahu.birthday;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.xiahu.domain.DBUser;
import com.xiahu.service.BirthdayService;
import com.xiahu.utils.DataSourceUtil;
import com.xiahu.utils.MailUtils;

/**
 * 
 * 定时发送生日祝福
 * 
 * @author Administrator
 *
 */
public class BirthdayListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent arg0) {

		// 当web应用启动 开启任务调动---功能在用户的生日当前发送邮件
		// 开启一个定时器
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// 为当前的生日的用户发邮件
				// 1、获得今天过生日的人
				// 获得今天的日期
				SimpleDateFormat format = new SimpleDateFormat("MM-dd");
				String todayDate = format.format(new Date());
				// 根据当前时间从数据查询今天过生日的人
				// 转发数据到service层
				BirthdayService service = new BirthdayService();
				List<DBUser> date = null;
				try {
					date = service.findBirthdayByDate(todayDate);
				} catch (SQLException e) {
					e.printStackTrace();
				}

				// 发送邮件
				if (date != null && date.size() > 0) {
					for (DBUser d : date) {
						try {
							MailUtils.sendMail(d.getEmail(), "生日祝福", "祝你生日快乐");
						} catch (MessagingException e) {
							e.printStackTrace();
						}
					}
				}

			}
		}, new Date(), 1000 * 10);
		// 实际开发中起始时间是一个固定的时间
		// 实际开发中间隔时间是1天

	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

}
