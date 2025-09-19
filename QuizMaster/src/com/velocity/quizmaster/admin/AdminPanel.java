package com.velocity.quizmaster.admin;

import java.util.Scanner;

import com.velocity.quizmaster.addquestions.TakeInput;
import com.velocity.quizmaster.allscore.GetScore;
import com.velocity.quizmaster.deletequestion.DeleteQuestion;
import com.velocity.quizmaster.editquestion.EditQuestion;
import com.velocity.quizmaster.scorebyid.StudentScoreById;
import com.velocity.quizmaster.topscore.getTopScore;

public class AdminPanel {

	private static Scanner sc = new Scanner(System.in);
	private boolean running = true;

	public void exit() {

		while (true) {// Exit and Retry Option (User Story 8.1)
			System.out.print("Do you want to continue? (Y/N): ");
			String input = sc.next();

			if (input.equalsIgnoreCase("Y")) {
				break; // back to menu
			} else if (input.equalsIgnoreCase("N")) {
				System.out.println("Exiting Admin... Goodbye!");
				running = false;
				break;
			} else {
				System.out.println("Invalid input. Please enter Y or N.");
			}
		}
	}

	public void adminControl() throws ClassNotFoundException {
		while (running) {
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
			sc.nextLine();
			switch (choice) {
			case 1:
				TakeInput t = new TakeInput();
				t.getInput();
				exit();
				break;

			case 2:
				EditQuestion eq = new EditQuestion();
				eq.editExistingQuestion();
				exit();
				break;

			case 3:
				DeleteQuestion dq = new DeleteQuestion();
				dq.deleteQuestionById();
				exit();
				break;

			case 4:
				GetScore gs = new GetScore();
				gs.getAllScore();
				exit();
				break;

			case 5:
				StudentScoreById sid = new StudentScoreById();
				sid.getScoreById();
				exit();
				break;

			case 6:
				getTopScore ts = new getTopScore();
				ts.getScore();
				exit();
				break;

			case 7:
				System.out.println("Exiting Admin... Goodbye!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice, please try again!");
			}
		}

	}
	
	public static void main(String[] args) throws ClassNotFoundException {
        AdminPanel admin = new AdminPanel();
        admin.adminControl(); // Start the admin panel
    }

}
