package com.xt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.xt.pojo.User;
import com.xt.util.DButil;
//管理员Dao
public class UserDao {
	public static Connection con=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	static{
		try {
			con=DButil.getCon();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean checkUser(String username,String password){
		String sql="select *from admin";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals(username)&&rs.getString(2).equals(password)){
					flag=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	public boolean updatePwd(String pwd,String username){
		String sql="update admin set password=? where username=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, pwd);
			ps.setString(2, username);
		int i=ps.executeUpdate();
		if(i==1){
			flag=true;
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	
	/**
	 * 更新用户信息
	 * 
	 * @param user
	 * @return
	 */
	public boolean updateUserInfo(User user) {
		String sql = "update user set tel=? ,email=? where loginname=?";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getTel());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getLoginname());
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 更新用户地址
	 * 
	 * @param username
	 * @param address
	 * @return
	 */
	public boolean updateAddress(String username, String address) {
		String sql = "update t_address set address=? where username=?";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, address);
			ps.setString(2, username);
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 检查用户密码
	 * 
	 * @param userName
	 * @param pass
	 * @return
	 */
	public boolean checkPass(String userName, String pass) {
		String sql = "select * from user where loginname=\'" + userName
				+ "\' and loginpwd=\'" + pass + "\'";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			System.out.println(sql);
			while (rs.next()) {
				flag = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 更改用户密码
	 * 
	 * @param userName
	 * @param pass
	 * @return
	 */
	public boolean updateUserPass(String userName, String pass) {
		String sql = "update user set loginpwd=? where loginname=?";
		boolean flag = false;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, userName);
			int i = ps.executeUpdate();
			if (i == 1) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
}
