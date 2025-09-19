package com.allscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.register.RegistrationPage;

public class GetStudentInfo {//View All Student Scores (Admin) (User Story 3.2)

	public List<StudentScore> getAllStudentScores() {
		List<StudentScore> scores = new ArrayList<>();
		String query = "SELECT s.id, s.first_name, s.last_name, sc.total_score, sc.grade " + "FROM student s "
				+ "JOIN score sc ON s.id = sc.student_id " + "ORDER BY sc.total_score ASC";

		try {
			Connection conn = RegistrationPage.getConnection();
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
