package com.xiahu.JDBC.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.xiahu.JDBC.util.MyDBCPUtil;

public class TestMyDBCPUtil {

	@Test
	public void InsertInfo() {
		Connection conn = null;
		PreparedStatement prep = null;
		MyDBCPUtil mydbcp = new MyDBCPUtil();
		try {
			conn = mydbcp.getConnection();
			String sql = "insert into tb_user values(?,?,?,?)";
			prep = conn.prepareStatement(sql);
			prep.setInt(1, 0);
			prep.setString(2, "大黄");
			prep.setString(3, "110");
			prep.setString(4, "78");
			int row = prep.executeUpdate();
			if(row>0){
				System.out.println("成功修改数据");
			}else{
				System.out.println("失败修改数据");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
