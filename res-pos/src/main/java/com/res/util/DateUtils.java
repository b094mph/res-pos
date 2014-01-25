package com.res.util;

import org.joda.time.DateTime;

public class DateUtils {

//	public static DateTime addMidnightStartTime(String requestDate){
//		int year = Integer.parseInt(requestDate.substring(0, 4));
//		int monthOfYear = Integer.parseInt(requestDate.substring(5, 7));
//		int dayOfMonth = Integer.parseInt(requestDate.substring(8, 10));
//		return new DateTime(year, monthOfYear, dayOfMonth, 0, 0, 0);
//	}
//	
//	public static DateTime addMidnightEndTime(String requestDate){
//		int year = Integer.parseInt(requestDate.substring(0, 4));
//		int monthOfYear = Integer.parseInt(requestDate.substring(5, 7));
//		int dayOfMonth = Integer.parseInt(requestDate.substring(8, 10));
//		return new DateTime(year, monthOfYear, dayOfMonth, 23, 59, 59);
//	}

	public static String addStartOfHour(String requestDate){
		return requestDate.concat(" 00:00:00");
	}
	
	public static String addEndOfHour(String requestDate){
		return requestDate.concat(" 23:59:59");
	}
	
	public static void main(String[] args){
		String requestDate = "2014-01-23";
		System.out.println(new DateTime());
		System.out.println(DateUtils.addStartOfHour(requestDate));
		System.out.println(DateUtils.addEndOfHour(requestDate));
	}
}
