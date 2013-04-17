package com.res.parse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import au.com.bytecode.opencsv.CSVParser;

public class FoodCategoryParser {
	
	private static String JDBC_CONNECTION_URL = 
			"jdbc:mysql://ec2-23-22-21-55.compute-1.amazonaws.com:3306/restaurant";
	private static String DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			CSVParser loader = new CSVParser();
			//TODO: how to parse csv to be placed in food, foodcategory, menu
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private static Connection getCon(){
		Connection connection = null;
		try{
			Class.forName(DRIVER_CLASSNAME);
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		return connection;
	}
}
