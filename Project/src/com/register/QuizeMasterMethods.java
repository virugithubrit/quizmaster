package com.register;

import java.sql.SQLException;

import java.util.Scanner;
import com.admin.AdminAllow;
import com.qustions.QuizeQuestions;
import com.score.ScoreCalculate;

public class QuizeMasterMethods {

	private static final Scanner sc = new Scanner(System.in);
	private boolean running = true;

	// Ask if the admin wants to continue
	private void promptContinue() {
		while (true) {
			System.out.print("Do you want to continue? (Y/N): ");
			String input = sc.nextLine().trim();
			if (input.equalsIgnoreCase("Y")) {
				break; // stay in menu
			} else if (input.equalsIgnoreCase("N")) {
				System.out.println("Exit... Goodbye!");
				running = false; // stop main loop
				System.exit(0);
				break;
			} else {
				System.out.println("Invalid input. Please enter Y or N.");
			}
		}
	}

	public void getQuizeMasterMethods() throws SQLException, ClassNotFoundException {

		while (running) {
			System.out.println("\nSelect your Choice : ");
			System.out.println("1. Perform Quiz");
			System.out.println("2. Perform Admin Operations");
			System.out.println("3. Exit");
			System.out.print("Enter your choice : ");

			int choice;
			try {
				choice = Integer.parseInt(sc.nextLine().trim());
			} catch (NumberFormatException e) {
				System.out.println("Please enter a valid number.");
				continue;
			}

			switch (choice) {
			case 1:
				int id = CheckValidation.checkingValidation();
				QuizeQuestions.getQuizeQuestions(id);
				ScoreCalculate.getScore(id, sc);
				promptContinue();

			case 2:
				AdminAllow.getAdminAllow(sc);
				promptContinue();

			case 3:
				System.out.println("Exit...!");
				running = false;

			default:
				System.out.println("Invalid choice, please try again!");
			}
		}
	}
}
