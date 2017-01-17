package com.bean;

public class User {
	private String User_name;
	private String password;
	private int User_id;
	private String flag;
	private String Login_time;
	public User(){}
	public User(String User_name, String password) {
		this.User_name=User_name;
		this.password=password;
	}
	public String getUser_name() {
		return User_name;
	}
	public void setUser_name(String user_name) {
		User_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getUser_id() {
		return User_id;
	}
	public void setUser_id(int user_id) {
		User_id = user_id;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getLogin_time() {
		return Login_time;
	}
	public void setLogin_time(String login_time) {
		Login_time = login_time;
	}

	
}
