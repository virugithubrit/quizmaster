package com.qustions;

import com.register.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class QuestionData {

	// User Story 2.1: Display Quiz Questions

	public static int questionsData() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Connection con = RegistrationPage.getConnection();
		int count = 0;
		try {
			// create the prepared statement
			PreparedStatement ps = con.prepareStatement(
					"SELECT question_text, option1, option2, option3, option4,correct_option FROM question ORDER BY RAND() LIMIT 1");
			ResultSet rs = ps.executeQuery();

			// -- display question from database --
			if (rs.next()) {
				String question = rs.getString("question_text");
				String option1 = rs.getString("option1");
				String option2 = rs.getString("option2");
				String option3 = rs.getString("option3");
				String option4 = rs.getString("option4");
				String correct_ans = rs.getString("correct_option");

				// --- Display questions with option --
				System.out.println("Question : " + question);
				System.out.println("1. Option A : " + option1);
				System.out.println("2. Option B : " + option2);
				System.out.println("3. Option C : " + option3);
				System.out.println("4. Option D : " + option4);

				System.out.println("Enter your answer (1-4):");
				String ans = sc.next().toLowerCase();
				if (ans.equals(correct_ans)) {
					System.out.println("Correct");
					// GradeClaculate.runQuize();
					count = 1;
				} else {
					System.out.println("Wrong! Correct answer is: " + correct_ans);
				}

			} else {
				System.out.println("Question not found");
			}
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return count;
	}

}
