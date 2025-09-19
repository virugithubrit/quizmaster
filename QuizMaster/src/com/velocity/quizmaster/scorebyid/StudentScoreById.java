package com.velocity.quizmaster.scorebyid;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentScoreById {// Search Student Score by ID (User Story 3.3)

	private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

	Scanner sc=new Scanner(System.in);
	public Connection getConnection() {
		Connection con = null;
		try {
			// load the Driver
			Class.forName(DB_Driver);
			// establish the connection
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return con;

	}

	public void getScoreById() {
		String query = "SELECT total_score, grade FROM score WHERE student_id = ?";

		try {

			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Enter Student Id to fetch their record");
			int studentId=sc.nextInt();
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int score = rs.getInt("total_score");
				String grade = rs.getString("grade");

				System.out.println("Score: " + score);
				System.out.println("Grade: " + grade);
			} else {
				System.out.println("No record found for Student ID: " + studentId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
