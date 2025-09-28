package com.velocity.quizmaster.score;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GradeCalculate {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Root";

	public static Connection getConnection() throws SQLException {
		Connection con = null;

		try {
			// Loading the drive
			Class.forName(DB_DRIVER);
			// Establish connection
			con = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed: " + e.getMessage());
		}
		return con;
	}

	public static void getScoreData(int id) {

		try {
			Connection con = getConnection();
			PreparedStatement ps = con
					.prepareStatement("select total_score,grade,feedback from score where student_id=?");
			ps.setLong(1, id);
			// n++;
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int totalScore = rs.getInt("total_score");
					String grade = rs.getString("grade");
					String message = rs.getString("feedback");

					// Print in the requested format
					System.out.println("Your Score: " + totalScore + " / 10");
					System.out.println("Your Grade: " + grade);
					System.out.println("Feedback: " + message);
				} else {
					System.out.println("No record found for id= " + id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		int studentId = 7;
		GradeCalculate.getScoreData(studentId);
	}

}
