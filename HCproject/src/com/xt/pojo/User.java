package com.xt.pojo;

public class User {

	private int id;
	private String loginname;
	private String loginpwd;
	private String realname;
	private String tel;
	private String email;
	private String zhuangtai;
	private String del;
	public User(int id, String loginname, String loginpwd, String realname,
			String tel, String email, String zhuangtai, String del) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.realname = realname;
		this.tel = tel;
		this.email = email;
		this.zhuangtai = zhuangtai;
		this.del = del;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User( String loginname, String loginpwd, String realname,
			String tel, String email) {
		super();
		this.loginname = loginname;
		this.loginpwd = loginpwd;
		this.realname = realname;
		this.tel = tel;
		this.email = email;
	}
	public User() {
		super();
	}
	
}
