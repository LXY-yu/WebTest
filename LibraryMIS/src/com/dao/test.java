package com.dao;

import java.text.SimpleDateFormat;

public class test {

	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		java.util.Date date=new java.util.Date();
		long now=date.getTime();
		java.sql.Date IdDateRetAct=new java.sql.Date(now);
		L_domain Ldo=new L_domain();
		System.out.println(IdDateRetAct);
		System.out.println(Ldo.returnBook("08042", 1, IdDateRetAct,"201404592",(float) 0.05));
		

	}

}
