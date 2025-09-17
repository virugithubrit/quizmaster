package com.score;

import java.sql.SQLException;

import com.quize.qustions.QuestionData;

public class GradeClaculate {

	public static String getGrade() throws SQLException {
 
		int score=GradeClaculate.runQuize();
		if (score >= 8) {
			return "A";
		} else if (score >= 5) {
			return "B";
		} else {
			return "C";
		}
	}
	
	public static int runQuize() {
		int n=0;
		return n++;
	}

}
