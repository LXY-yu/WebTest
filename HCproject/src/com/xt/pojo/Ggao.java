package com.xt.pojo;

public class Ggao {

	private int tid;
	private int proid;
	private String tuisong;
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public int getProid() {
		return proid;
	}
	public void setProid(int proid) {
		this.proid = proid;
	}
	public String getTuisong() {
		return tuisong;
	}
	public void setTuisong(String tuisong) {
		this.tuisong = tuisong;
	}
	public Ggao(int tid, int proid, String tuisong) {
		super();
		this.tid = tid;
		this.proid = proid;
		this.tuisong = tuisong;
	}
	public Ggao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
