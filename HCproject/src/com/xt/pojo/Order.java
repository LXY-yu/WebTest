package com.xt.pojo;

public class Order {

	private String orderid;
	private String username;
	private  String totalprice;
	private String address;
	private String zhuangtai;
	private String detail;
	private String time;
	public Order(String orderid, String username, String totalprice,
			String address, String zhuangtai, String detail, String time) {
		super();
		this.orderid = orderid;
		this.username = username;
		this.totalprice = totalprice;
		this.address = address;
		this.zhuangtai = zhuangtai;
		this.detail = detail;
		this.time = time;
	}
	
	
	public Order() {
		super();
	}


	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
}
