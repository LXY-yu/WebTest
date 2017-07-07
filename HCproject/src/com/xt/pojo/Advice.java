package com.xt.pojo;

public class Advice {

	private int adviceid;
	private String username;
	private String content;
	private String time;
	private String huifu;
	public int getAdviceid() {
		return adviceid;
	}
	public void setAdviceid(int adviceid) {
		this.adviceid = adviceid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getHuifu() {
		return huifu;
	}
	public void setHuifu(String huifu) {
		this.huifu = huifu;
	}
	public Advice(int adviceid, String username, String content, String time,
			String huifu) {
		super();
		this.adviceid = adviceid;
		this.username = username;
		this.content = content;
		this.time = time;
		this.huifu = huifu;
	}
	public Advice(String username, String content, String time, String huifu) {
		super();
		this.username = username;
		this.content = content;
		this.time = time;
		this.huifu = huifu;
	}
	
	
}
