package com.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.register.RegistrationPage;
import com.register.UserRegisterData;

public class LoginPage {
	// ----------This method for user login successfully---//
	public boolean getUserData(UserRegisterData srd) {
		
		RegistrationPage rp = new RegistrationPage();
		
		// Connection con1 = getConnection();
		String query = "select * from student where username=? and password=?";
		// System.out.println("c execute");
		try (Connection con1 = rp.getConnection();

				PreparedStatement pst = con1.prepareStatement(query)) {

			pst.setString(1, srd.getUserName());
			pst.setString(2, srd.getPassword());
			ResultSet rs = pst.executeQuery();
			return rs.next(); // true if username & password match

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // false if username & password match
		}

	}

	// -------This method for user already register------//
	public boolean checkingvalidation(String userName) {

		// Connection con1 = getConnection();
		String query = "select * from student where username=?";
		try (Connection con1 = RegistrationPage.getConnection();

				PreparedStatement pst = con1.prepareStatement(query)) {
			pst.setString(1, userName);
			ResultSet rs = pst.executeQuery();
			return rs.next(); // true if user name match

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // false if user name match
		}

	}
	
	
	public boolean checkingvalidation(String userName,String password) {

		// Connection con1 = getConnection();
		String query = "select id from student where username=? and password=?";
		try (Connection con1 =RegistrationPage.getConnection();

				PreparedStatement pst = con1.prepareStatement(query)) {
			pst.setString(1, userName);
			pst.setString(2, password);
			
			ResultSet rs = pst.executeQuery();
			return rs.next(); // true if username,password match

		} catch (SQLException e) {
			e.printStackTrace();
			return false; // false if username,password match
		}

	}
	
	

}
