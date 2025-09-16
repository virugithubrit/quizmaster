package com.register;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	private static final String DB_Url = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String DB_Username = "root"; // mysql workbench username
	private static final String DB_Password = "Root";// mysql workbench password
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName(DB_Driver);
			conn =  DriverManager.getConnection(DB_Url, DB_Username, DB_Password);
		} catch (Exception e) {
			System.out.println("DB Connection Failed: " + e.getMessage());
		}
		
		return conn; //return the connection 
	}
   
}
