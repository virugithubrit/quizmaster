package com.qustions;

import java.sql.SQLException;
import java.util.Scanner;

import com.score.GradeCalculate;
import com.score.ScoreStoreDB;

public class QuizeQuestions {

	public static void getQuizeQuestions(int studentId) throws SQLException {
		GradeCalculate gc=new GradeCalculate();
		try  {
			System.out.println("3. Attempt Quiz");
			String boldText = "\033[1m=== Java Quiz ===\033[0m";
			System.out.println(boldText);
			System.out.println("Each question has 4 options. Enter your choice (1-4).");
			int score = 0;
			for (int n = 1; n <= 10; n++) {
				System.out.println("Question . " + n);
				try {

					score += QuestionData.questionsData();

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			String message = gc.getMessage(score);
			String grade =gc.getGrade(score);
			ScoreStoreDB.setScoreDB(studentId, score, grade, message);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
