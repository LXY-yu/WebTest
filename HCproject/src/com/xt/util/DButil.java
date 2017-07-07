package com.xt.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DButil {
  public static String driver=null;
  public static String url=null;
  static{
	  Properties ps=new Properties();
	  InputStream in=DButil.class.getResourceAsStream("/database.properties");
	  try {
		ps.load(in);
		driver=ps.getProperty("driverClass");
		url=ps.getProperty("url");
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
  public static Connection getCon() throws Exception{
		Class.forName(driver);
		Connection con=DriverManager.getConnection(url);
		return con;
	}
	public static void getClose(Connection con) throws SQLException{
		if(con!=null){
				con.close();
		}
	}
}
