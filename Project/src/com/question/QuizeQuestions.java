package com.question;

import java.sql.SQLException;
import java.util.Scanner;

import com.register.CheckValidation;
import com.register.RegistrationPage;
import com.register.UserRegisterData;
import com.score.GradeCalculate;
import com.score.ScoreStoreDB;

public class QuizeQuestions {

	// !--- This method used display the quiz question format ---!
	public static void getQuizeQuestions(int studentId) throws SQLException {
		// creating object of GradeClaculate
		GradeCalculate gc = new GradeCalculate();
		Scanner sc = new Scanner(System.in);
		System.out.println("3. Attempt Quiz");
		String boldText = "\033[1m=== Java Quiz ===\033[0m";
		System.out.println(boldText);
		System.out.println("Each question has 4 options. Enter your choice (1-4).");
		
		int score = 0;
		// -- Used for loop for display only 10 question
		for (int n = 1; n <= 10; n++) {
			System.out.println("Question . " + n);
			try {

				// getting the question one by one from questionsData() and also calculate score

				score += QuestionData.questionsData();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// ---used score to calculate grade---
		String grade = gc.getGrade(score);
		// ---used score to calculate message based on score grade---
		String message = gc.getMessage(score);
		if (studentId > 0) {
		    ScoreStoreDB.setScoreDB(studentId, score, grade, message);
		}
		// -- Store the score and grade to data base
		
	}

}
