package com.dao;

import java.util.List;

import com.bean.User;

public class test {

	public static void main(String[] args) {
		String username ="HCY";
		String password ="08042";
		User u=new User(username,password);
		addUser.add(u);
		List<User> list=addUser.showOnlineUser();
	System.out.println(list.size());

	}

}
