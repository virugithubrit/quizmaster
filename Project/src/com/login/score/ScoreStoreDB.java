package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.quize.qustions.QuestionData;
import com.register.RegistrationPage;

public class ScoreStoreDB {

	public static void setScoreDB(int score1,int score,String grade) throws SQLException {
		
		Connection con=RegistrationPage.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into score(total_score,grade)values(?,?)");
			//ps.setLong(1, studentId);
			ps.setLong(1,score);
			ps.setString(2,grade);
			ps.executeUpdate();
			System.out.println("Score added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getScoreData() {
		Connection con=RegistrationPage.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("select total_score,grade from score where id=?");
			ps.setLong(1,7);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {  // move to the first row
	                int totalScore = rs.getInt("total_score");
	                String grade = rs.getString("grade");

	                System.out.println("Total Score: " + totalScore);
	                System.out.println("Grade: " + grade);
	            } else {
	                System.out.println("No record found for id=7");
	            }
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
