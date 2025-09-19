package com.register;

import java.sql.SQLException;

import com.admin.AdminPanel;
import com.question.QuizeQuestions;
import com.score.ScoreCalculate;

public class QuizeMasterMethods {

	public static void getQuizeMasterMethods() throws SQLException, ClassNotFoundException {
		// --calling this for checking for validations--
		//int id= CheckValidation.checkingValidation();
		// ---if user login successfully after that using this method perform quiz
	//	QuizeQuestions.getQuizeQuestions(id);
		// ---after perform quiz this method display the quiz
		//ScoreCalculate.getScore();
		
		 AdminPanel ap=new AdminPanel();
		 ap.adminControl();
	}

}
