package com.bean;

import java.util.List;

public class Command {
	private String id;
	private String name;
	private String discription;
	
	private List<CommandContent> contentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public List<CommandContent> getContentList() {
		return contentList;
	}

	public void setContentList(List<CommandContent> contentList) {
		this.contentList = contentList;
	}

	
}
