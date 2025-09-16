package com.velocity.quizmaster.addquestions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AddQuestion  {//Add New Questions (User Story 3.1)

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
		String sql = "INSERT INTO question (question_text, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		try{

			Connection conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, question.getQuestionText());
			pstmt.setString(2, question.getOption1());
			pstmt.setString(3, question.getOption2());
			pstmt.setString(4, question.getOption3());
			pstmt.setString(5, question.getOption4());
			pstmt.setString(6, question.getCorrectOption());

			int rows = pstmt.executeUpdate();
			return rows > 0; // true if insertion worked

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}
}
