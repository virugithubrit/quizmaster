package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.register.UserRegisterData;

public class LoginPage {
	// User Story 1.1: Student Registration
	private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/quizemastertables";
	private static final String DB_Username = "root";
	private static final String DB_Password = "root";

	public Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver
			Class.forName(DB_Driver);
			// establish the connection
			con = DriverManager.getConnection(DB_URL, DB_Username, DB_Password);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return con;
	}
    //----------This method for user login successfully---//
	public boolean getUserData(UserRegisterData srd) {

		//Connection con1 = getConnection();
		String query = "select * from student where username=? and password=?";
		//System.out.println("c execute");
		try (Connection con1 = getConnection();

				PreparedStatement pst = con1.prepareStatement(query)) 
		{
			
			pst.setString(1, srd.getUserName());
			pst.setString(2, srd.getPassword());
			ResultSet rs = pst.executeQuery();
			return rs.next(); // true if username & password match

		} catch (SQLException e) {
			e.printStackTrace();
			return false;    //  false if username & password match
		}

	}
	
	//-------This method for user already register------//
	public boolean checkingvalidation(String userName) {

		//Connection con1 = getConnection();
		String query = "select * from student where username=?";
		try (Connection con1 = getConnection();
              
				PreparedStatement pst = con1.prepareStatement(query)) 
		{            
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
		    return rs.next(); // true if username match

		} catch (SQLException e) {
			e.printStackTrace();
			return false;    //  false if username match
		}

	}
	
	
	
	

}
