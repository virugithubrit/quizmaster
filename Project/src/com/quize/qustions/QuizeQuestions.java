package com.quize.qustions;

import java.sql.SQLException;
import java.util.Scanner;

import com.score.GradeClaculate;
import com.score.ScoreStoreDB;

public class QuizeQuestions {

	public static void getQuizeQuestions() {
		Scanner sc = new Scanner(System.in);
		System.out.println("3. Attempt Quiz");
		String boldText = "\033[1m=== Java Quiz ===\033[0m";
		System.out.println(boldText);
		System.out.println("Each question has 4 options. Enter your choice (1-4).");
		// int n1=0;
		for (int n = 1; n <= 10; n++) {
			System.out.println("Question . " + n);
			try {

				int score=QuestionData.questionsData();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void  score() throws SQLException {
		int score1=GradeClaculate.runQuize();
		String grade=GradeClaculate.getGrade();
		System.out.println(score1);
		System.out.println(grade);
		ScoreStoreDB.setScoreDB(score1,grade);
	}

}
