package com.baizhi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class SaveAddressImpl implements SaveAddressDAO {
	private static Connection conn;
	private static String sql;
	private static Statement stmt;
	static {
		try {
			// 寤虹珛鏁版嵁搴撶殑杩炴帴 杩炴帴Mysql
			Class.forName("com.mysql.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf8";
			conn = DriverManager.getConnection(dburl, "root", "1234");
			System.out.println(" 杩炴帴宸茬粡寤虹珛锛�");

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public void save(String address) {
		// TODO Auto-generated method stub
		sql = "select * from url where status = '0'";

		try {
			// 鍋歩f鏉′欢鍒ゆ柇 鏌ョ湅琛ㄤ腑鏄惁宸茬粡娣诲姞鐩稿悓鐨刄rl 鍋囪璇rl宸茬粡瀛樺湪鍒欎笉娣诲姞
			ResultSet rs = stmt.executeQuery(sql);
			if (!rs.next()) {
				sql = "insert into url (url,status) values";
				Statement stmt = conn.createStatement();
				stmt.execute(sql);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
