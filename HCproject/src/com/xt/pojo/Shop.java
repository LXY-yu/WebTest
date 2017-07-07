package com.xt.pojo;

public class Shop {

	private int shopid;
	private String username;
	private int id;
	private String pname;
	private String price;
	private int count;
	private String img;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getShopid() {
		return shopid;
	}
	public void setShopid(int shopid) {
		this.shopid = shopid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	public Shop(String username,int id, String pname, String price, int count,String img) {
		super();
		this.username=username;
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.count = count;
		this.img=img;
	}
	
	public Shop(int shopid,String username, int id, String pname, String price, int count,String img) {
		super();
		this.shopid = shopid;
		this.username=username;
		this.id = id;
		this.pname = pname;
		this.price = price;
		this.count = count;
		this.img=img;
	}
	public Shop() {
		super();
	}
	
}
