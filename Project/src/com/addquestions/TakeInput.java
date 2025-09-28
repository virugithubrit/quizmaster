package com.addquestions;

import java.sql.SQLException;
import java.util.Scanner;

public class TakeInput {
	// ---Add New Questions (User Story 3.1)---
	private final Scanner sc;

	// Pass the shared scanner in constructor
	public TakeInput(Scanner sc) {
		this.sc = sc;
	}

	public void getInput() throws SQLException {

		System.out.println("Enter Question Text:");
		String questionText = sc.nextLine();

		System.out.println("Enter Option 1:");
		String option1 = sc.nextLine();

		System.out.println("Enter Option 2:");
		String option2 = sc.nextLine();

		System.out.println("Enter Option 3:");
		String option3 = sc.nextLine();

		System.out.println("Enter Option 4:");
		String option4 = sc.nextLine();

		System.out.println("Enter Correct Option (must m2"
				+ "atch one of the above):");
		String correctOption = sc.nextLine();

		Questions question = new Questions(questionText, option1, option2, option3, option4, correctOption);

		AddQuestion dao = new AddQuestion();
		if (dao.addQuestion(question)) {
			System.out.println("Question added successfully!");
		} else {
			System.out.println("Failed to add question.....try agarin!");
			getInput();
		}

	}

}
