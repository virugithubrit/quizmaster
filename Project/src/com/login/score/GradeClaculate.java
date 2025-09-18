package com.score;

import java.sql.SQLException;

import com.quize.qustions.QuestionData;

public class GradeClaculate {

	public  String getGrade(int score) throws SQLException {

		if (score >= 8) {
			return "A";
		} else if (score >= 5) {
			return "B";
		} else {
			return "C";
		}
	}

	public String getGrade1(int score) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
	

}
