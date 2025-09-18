package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.register.RegistrationPage;

public class ScoreStoreDB {

	// -- this method store the score into database--
	public static void setScoreDB(int score, String grade, String message) throws SQLException {

		Connection con = RegistrationPage.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("insert into score(total_score,grade,message)values(?,?,?)");
			ps.setLong(1, score);
			ps.setString(2, grade);
			ps.setString(3, message);
			ps.executeUpdate();
			System.out.println("Score added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// --this method fetch the score and grade from the database--
	public static void getScoreData() {
		int n = 1;
		Connection con = RegistrationPage.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select total_score,grade,message from score where id=?");
			ps.setLong(1, n);
			n++;
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					int totalScore = rs.getInt("total_score");
					String grade = rs.getString("grade");
					String message = rs.getString("message");

					// Print in the requested format
					System.out.println("Your Score: " + totalScore + " / 10");
					System.out.println("Your Grade: " + grade);
					System.out.println("Feedback: " + message);
				} else {
					System.out.println("No record found for id=n");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
