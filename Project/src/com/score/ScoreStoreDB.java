package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.quize.qustions.QuestionData;
import com.register.RegistrationPage;
import com.register.UserRegisterData;

public class ScoreStoreDB {

	public static void setScoreDB(int score, String grade,String message) throws SQLException {

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

	public static void getScoreData() {
		int n=1;
		Connection con = RegistrationPage.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("select total_score,grade,message from score where id=?");
			ps.setLong(1, n);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) { 
					int totalScore = rs.getInt("total_score");
					String grade = rs.getString("grade");
					String message = rs.getString("message");
                    
					System.out.println("Total Score: " + totalScore);
					System.out.println("Grade: " + grade);
					System.out.println("message: " + message);
				} else {
					System.out.println("No record found for id=n");
				}
			}n++;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
