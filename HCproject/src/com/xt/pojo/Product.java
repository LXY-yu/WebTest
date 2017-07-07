package com.xt.pojo;

public class Product {

	private int id;
	private String type;
	private String pname;
	private String price;
	private String zhuangtai;
	private String img;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getZhuangtai() {
		return zhuangtai;
	}
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Product(int id, String type, String pname, String price,
			String zhuangtai, String img) {
		super();
		this.id = id;
		this.type = type;
		this.pname = pname;
		this.price = price;
		this.zhuangtai = zhuangtai;
		this.img = img;
	}
	
	public Product(String type, String pname, String price, String zhuangtai,
			String img) {
		super();
		this.type = type;
		this.pname=pname;
		this.price = price;
		this.zhuangtai = zhuangtai;
		this.img = img;
	}
	public Product() {
		super();
	}
	
}
