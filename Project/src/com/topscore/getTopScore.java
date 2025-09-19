package com.topscore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getTopScore {

	public void getScore() {
		String url = "jdbc:mysql://localhost:3306/quizmaster";
		String user = "root";
		String password = "root";

		try {
			String sql = "SELECT s.first_name, s.last_name, sc.total_score, sc.grade " + "FROM student s "
					+ "JOIN score sc ON s.id = sc.student_id "
					+ "WHERE sc.total_score = (SELECT MAX(total_score) FROM score)";
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			System.out.println(" Top Scorer(s):");
			while (rs.next()) {
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				int score = rs.getInt("total_score");
				String grade = rs.getString("grade");

				System.out.println("Student Name: " + fname + " " + lname);
				System.out.println("Score: " + score + " / 10");
				System.out.println("Grade: " + grade);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
