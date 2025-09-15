package com.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class RegistrationPage {

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

	public void saveStudent(StudentRegisterData srd) {
		Connection con = getConnection();
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				// create prepared statement
				PreparedStatement ps = con.prepareStatement(
						"insert into student(first_name,last_name,username,password,city,email,mobile)values(?,?,?,?,?,?,?)");
				System.out.println("hii");
				ps.setString(1, srd.getFirstName());
				ps.setString(2, srd.getLastName());
				ps.setString(3, srd.getUserName());
				ps.setString(4, srd.getPassword());
				ps.setString(5, srd.getCity());
				ps.setString(6, srd.getEmailId());
				ps.setString(7, srd.getMobileNumber());
				int n = ps.executeUpdate();
				System.out.println(n + "row inserted seccussfully...");
				break;
			} catch (SQLIntegrityConstraintViolationException dupEx) {
				String msg = dupEx.getMessage();

				if (msg.contains("student.username")) {
					System.out.print("This username is already registered. Please enter a different username: ");
					srd.setUserName(sc.nextLine().trim());
				} else if (msg.contains("student.email")) {
					System.out.print("This email is already registered. Please enter a different email: ");
					srd.setEmailId(sc.nextLine().trim());
				} else if (msg.contains("student.password")) {
					System.out.print("This password is already registered. Please enter a different password: ");
					srd.setPassword(sc.nextLine().trim());
				} else if (msg.contains("student.mobile")) {
					System.out.print(
							"This mobile number is already registered. Please enter a different mobile number: ");
					srd.setMobileNumber(sc.nextLine().trim());
				} else {
					System.out.println("Duplicate entry: " + msg);
					break; // or decide to retry
				}
				// loop repeats to try insert again with updated data
			} catch (Exception se) {
				se.printStackTrace();
			}

		}
		sc.close();
	}

}
