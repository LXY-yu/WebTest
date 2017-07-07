package com.xt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xt.pojo.User;
import com.xt.util.DButil;

public class QdUser {

	public static Connection con=null;
	public static PreparedStatement ps=null;
	public static ResultSet rs=null;
	static{
		try {
			con=DButil.getCon();
		} catch (Exception e) {
		}
	}
	//查找用户
	public List<User> selUser(){
		String sql="select *from user";
		List<User> list=new ArrayList<User>();
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				list.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	//判断用户是否存在
	public boolean IfUser(String username,String pwd){
		String sql="select *from user";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				if(rs.getString(2).equalsIgnoreCase(username)&&rs.getString(3).equalsIgnoreCase(pwd)&&rs.getString(7).equalsIgnoreCase("b")){
					flag=true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//插入用户信息
	public boolean InsertUser(User user){
		String sql="insert into user(loginname,loginpwd,realname,tel,email,zhuangtai,del) values(?,?,?,?,?,?,?)";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,user.getLoginname());
			ps.setString(2,user.getLoginpwd());
			ps.setString(3,user.getRealname());
			ps.setString(4, user.getTel());
			ps.setString(5, user.getEmail());
			ps.setString(6, "a");
			ps.setString(7, "yes");
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	//删除用户
	public boolean delUser(int id){
		String sql="delete from user where id=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			int i=ps.executeUpdate();
			if(i==1){
				flag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	//审核用户
	public boolean ShenHeUser(int id){
		String sql="update user set zhuangtai=? where id=?";
		boolean flag=false;
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, "b");
			ps.setInt(2, id);
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
	 * 获取用户信息 根据 loginname 获取用户相关的信息
	 * 
	 * @return
	 */
	public User getUserInfo(String userName) {
//		System.out.println(userName);
		String sql = "select * from user where loginname=\'" + userName + "\'";
		// System.out.println("==========" + sql);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				String loginname = rs.getString(2);
				String tel = rs.getString(5);
				String email = rs.getString(6);
				User user = new User();
				user.setLoginname(loginname);
				user.setTel(tel);
				user.setEmail(email);
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 根据用户名获取用户的地址
	 * 
	 * @param userName
	 * @return
	 */
	public String getUserAddress(String userName) {
		String sql = "select * from t_address where username=\'" + userName
				+ "\'";
//		System.out.println("==========" + sql);
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
