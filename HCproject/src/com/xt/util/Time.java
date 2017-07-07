package com.xt.util;

import java.text.SimpleDateFormat;
import java.util.Date;



public class Time {

	
	public  static String getDate(){
		SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		String now=sf.format(date);
	
		return now;
	}
	
}
