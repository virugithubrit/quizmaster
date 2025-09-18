package com.velocity.quizmaster.summary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Quizsummary {

	private static final String URL = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String USER = "root";
	private static final String PASSWORD = "root";

	public static void showSummary(int studentId) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);

			String query = "SELECT total_score, grade FROM score WHERE student_id = ? ORDER BY student_id DESC LIMIT 1";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int score = rs.getInt("total_score");
				String grade = rs.getString("grade");

				int totalQuestions = 10;
				int correctAnswers;
				int wrongAnswers;

				correctAnswers = score;

				wrongAnswers = totalQuestions - correctAnswers;

				// Print Summary
				System.out.println("\n===== Quiz Summary =====");
				System.out.println("Total Questions: " + totalQuestions);
				System.out.println("Correct Answers: " + correctAnswers);
				System.out.println("Wrong Answers  : " + wrongAnswers);
				System.out.println("Score          : " + score);
				System.out.println("Grade          : " + grade);
			} else {
				System.out.println(" No quiz record found for studentId: " + studentId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Test
	public static void main(String[] args) {
		showSummary(1);
	}

}
