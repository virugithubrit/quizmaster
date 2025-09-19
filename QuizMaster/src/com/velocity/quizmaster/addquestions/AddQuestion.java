package com.velocity.quizmaster.addquestions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddQuestion {// Add New Questions (User Story 3.1)

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

	public boolean addQuestion(Questions question) {
		String checkSql = "SELECT COUNT(*) FROM question WHERE question_text = ?";
		String sql = "INSERT INTO question (question_text, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		Connection conn = getConnection();

		try { // Prevent Duplicate Questions (User Story 6.1)
			ps = conn.prepareStatement(checkSql);
			ps.setString(1, question.getQuestionText());
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count = rs.getInt(1);

			if (count > 0) {
				System.out.println("Duplicate question. Skipping insertion.");
				return false; // exit the method immediately
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {

			ps = conn.prepareStatement(sql);
			ps.setString(1, question.getQuestionText());
			ps.setString(2, question.getOption1());
			ps.setString(3, question.getOption2());
			ps.setString(4, question.getOption3());
			ps.setString(5, question.getOption4());
			ps.setString(6, question.getCorrectOption());

			int rows = ps.executeUpdate();
			return rows > 0; // true if insertion worked

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}
}
