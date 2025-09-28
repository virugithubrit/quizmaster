package com.addquestions;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.register.RegistrationPage;

public class AddQuestion {// Add New Questions (User Story 3.1)

	public boolean addQuestion(Questions question) throws SQLException {
		String checkSql = "SELECT COUNT(*) FROM question WHERE question_text = ?";
		String sql = "INSERT INTO question (question_text, option1, option2, option3, option4, correct_option) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		ResultSet rs=null;
		Connection conn = RegistrationPage.getConnection();

		try { // Prevent Duplicate Questions (User Story 6.1)
			ps = conn.prepareStatement(checkSql);
			ps.setString(1, question.getQuestionText());
			 rs = ps.executeQuery();
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
		}finally {
			conn.close();
			ps.close();
			rs.close();
		}
		
		return false;

	}
}
