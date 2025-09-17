package com.score;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;
import com.quize.qustions.QuestionData;
import com.register.RegistrationPage;

public class ScoreStoreDB {

	public static void setScoreDB(int score,String grade) throws SQLException {
		
		Connection con=RegistrationPage.getConnection();
		try {
			PreparedStatement ps=con.prepareStatement("insert into score(total_score,grade)values(?,?)");
			
			ps.setLong(1,score);
			ps.setString(2,grade);
			ps.executeUpdate();
			System.out.println("Score added successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
