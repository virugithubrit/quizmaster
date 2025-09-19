package com.register;

import java.sql.SQLException;

import com.question.QuizeQuestions;
import com.score.ScoreCalculate;

public class QuizeMasterMethods {

	public static void getQuizeMasterMethods() throws SQLException {
		// --calling this for checking for validations--
		CheckValidation.checkingValidation();
		// ---if user login successfully after that using this method perform quiz
		QuizeQuestions.getQuizeQuestions();
		// ---after perform quiz this method display the quiz
		ScoreCalculate.getScore();
	}

}
