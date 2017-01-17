package com.util;

import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	
public class DBUtil {
 
		// 连接mysql
		private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=Users";
		private static final String UID = "hcy";
		private static final String PWD = "08042";
		private static Connection con = null;
		private static PreparedStatement ps = null;
		private static ResultSet rs = null;

		// 连接sql
		// private static final String driver =
		// "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		// private static final String url =
		// "jdbc:sqlserver://localhost:1433;DatabaseName=stus";
		// private static final String uid = "sa";
		// private static final String pwd = "123";

		// 登录
		// DriverManager
		// Connection
		// PreparedStatement
		// ResultSet
		protected static boolean executeExecute(Object[] objects, String sql)
				throws Exception {
			boolean bo = false;
			ps = createPreparedStatement(sql, objects);
			rs = ps.executeQuery();
			bo = rs.next();
			close(con, ps, rs);
			return bo;

		}

		// 增/删/改
		// DriverManager
		// Connection
		// PreparedStatement
		protected static boolean executeUpdate(String sql, Object... objects)
				throws Exception {
			boolean bo = false;
			ps = createPreparedStatement(sql, objects);
			bo = ps.executeUpdate() != 0 ? true : false;
			close(con, ps, null);
			return bo;
		}

		// 查询
		// DriverManager
		// Connection
		// PreparedStatement
		// ResultSet
		protected static ResultSet executeQuery(String sql, Object... objects)
				throws Exception {
			ps = createPreparedStatement(sql, objects);
			rs = ps.executeQuery();
			// close(con, ps, rs);
			return rs;
		}
		//创建执行sql语句对象
		private static PreparedStatement createPreparedStatement(String sql,
				Object... objects) throws Exception {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, UID, PWD);
			ps = con.prepareStatement(sql);
			for (int i = 0; i < objects.length; i++) {
				ps.setObject(i + 1, objects[i]);
			}
			return ps;
		}

		private static void close(Connection con, PreparedStatement ps, ResultSet rs)
				throws Exception {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		}

	


}
