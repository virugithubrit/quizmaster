package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.register.RegistrationPage;

public class ScoreStoreDB {

	// -- this method store the score into database--

	public static void setScoreDB(int studentId, int score, String grade, String message) throws SQLException {
       // studentId=1;
		Connection con = RegistrationPage.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("insert into score(student_id,total_score,grade,feedback)values(?,?,?,?)");
			System.out.println("studentId :" + studentId);
			ps.setLong(1, studentId);
			ps.setLong(2, score);
			ps.setString(3, grade);
			ps.setString(4, message);
			ps.executeUpdate();
			System.out.println("Score added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block e.printStackTrace(); }
		}

	}
	

	public static int fetchStudentId(String username) {
		String sql = "SELECT id FROM student WHERE username = ?";
		try (Connection con = RegistrationPage.getConnection(); PreparedStatement pst = con.prepareStatement(sql)) {

			pst.setString(1, username);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					return rs.getInt("id");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0; // 0 if not found
	}
	// --this method fetch the score and grade from the database--
	public static void getScoreData(int id) {
	
		Connection con = RegistrationPage.getConnection();
		try {
			PreparedStatement ps = con
					.prepareStatement("select total_score,grade,feedback from score where student_id=?");
			ps.setLong(1, id);
			n++;
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
					System.out.println("No record found for id= "+id);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
