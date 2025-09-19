package com.score;

import java.sql.SQLException;

import com.question.QuestionData;

public class GradeClaculate {
	// --This method used to calculate the grade--
	public String getGrade(int score) throws SQLException {

		if (score >= 8) {
			return "A";
		} else if (score >= 5) {
			return "B";
		} else {
			return "C";
		}
	}

	// --this method provide the feedback--
	public String getMessage(int score) {

		if (score >= 8) {
			return "Excellent";
		} else if (score >= 5) {
			return "Good";
		} else {
			return "Needs Improvement";
		}

	}

}
