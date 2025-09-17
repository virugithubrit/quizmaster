package com.velocity.quizmaster.admin;

import java.util.Scanner;

import com.velocity.quizmaster.addquestions.TakeInput;
import com.velocity.quizmaster.allscore.GetScore;
import com.velocity.quizmaster.scorebyid.StudentScoreById;

public class AdminPanel {

	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n=== ADMIN OPERATIONS ===");
			System.out.println("1. Add New Question");
			System.out.println("2. Edit Existing Question");
			System.out.println("3. Delete Question");
			System.out.println("4. View All Student Scores");
			System.out.println("5. Fetch Score by Student ID");
			System.out.println("6. View Top Scorer");
			System.out.println("7. Exit");
			System.out.print("Enter your choice: ");

			int choice = sc.nextInt();
			

			switch (choice) {
			case 1:
				TakeInput t=new TakeInput();
				t.getInput();
				break;

			case 2:
//				editQuestion();
				break;

			case 3:
//				deleteQuestion();
				break;

			case 4:
				GetScore gs=new GetScore();
				gs.getAllScore();
				break;

			case 5:
				StudentScoreById sid=new StudentScoreById();
				sid.getScoreById();
				break;

			case 6:
//				viewTopScorer();
				break;

			case 7:
				System.out.println("Exiting... Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice, please try again!");
			}
		}

	}

}
