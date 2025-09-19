package com.velocity.quizmaster.allscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GetStudentInfo {//View All Student Scores (Admin) (User Story 3.2)

	private static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";

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

	public List<StudentScore> getAllStudentScores() {
		List<StudentScore> scores = new ArrayList<>();
		String query = "SELECT s.id, s.first_name, s.last_name, sc.total_score, sc.grade " + "FROM student s "
				+ "JOIN score sc ON s.id = sc.student_id " + "ORDER BY sc.total_score ASC";

		try {
			Connection conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				int totalScore = rs.getInt("total_score");
				String grade = rs.getString("grade");

				scores.add(new StudentScore(id, firstName, lastName, totalScore, grade));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return scores;
	}
}
