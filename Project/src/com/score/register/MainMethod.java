package com.register;

import java.sql.SQLException;

import com.quize.qustions.QuizeQuestions;
import com.score.ScoreCalculate;

public class MainMethod {

	// !-- This is the entry point of code(Main method) --!

	public static void main(String[] args) throws SQLException {
		CheckValidation cv = new CheckValidation();
		// --calling this for checking for validations
		cv.checkingValidation();
		QuizeQuestions.getQuizeQuestions();
		ScoreCalculate.getScore();
		
	}
}
