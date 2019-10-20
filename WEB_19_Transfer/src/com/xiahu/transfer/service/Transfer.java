package com.xiahu.transfer.service;

import java.sql.SQLException;

import com.xiahu.Utils.DataSourceUtil;
import com.xiahu.transfer.dao.dao;

public class Transfer {
	// 是否转账成功
	public static boolean isTransferSuccess(String out, String in, Double money) throws SQLException {
		
		boolean flag = true;

		// 事务开启
		DataSourceUtil.setAutoCommit();

		// 调用dao层的转账方法
		try {
			// 转出
			dao.out(out, money);
			// 转入
			dao.in(in, money);
		} catch (Exception e) {
			flag = false;
			// 事务回滚
			DataSourceUtil.rollback();

		} finally {

			// 提交事务
			DataSourceUtil.commit();

		}

		return flag;
	}

}
