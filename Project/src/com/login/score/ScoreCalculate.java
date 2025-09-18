package com.score;

import java.sql.SQLException;
import java.util.Scanner;

import com.login.LoginPage;
import com.quize.qustions.QuizeQuestions;
import com.register.RegistrationLoginData;

public class ScoreCalculate {

	public static void getScore() throws SQLException {
		LoginPage lp = new LoginPage();
		Scanner sc = new Scanner(System.in);
		String boldText = "\033[1m!=== View Quiz Result ===!\033[0m";
		System.out.println(boldText);
		String userName = null;
		//int userAttempt=0;
		while (true) {
			System.out.println("Enter Username : ");
			userName = sc.nextLine().trim();

			// check not empty and letters and alphabet only
			if (userName.isEmpty()) {
				System.out.println("User name cannot be empty. Please try again.");
				continue;
			}
			else if (!userName.matches("^[A-Za-z][A-Za-z0-9_]{2,19}")) {
				System.out.println("User name must contain letters,digits and underScore(_). Please try again.");
				continue;
			}else {
				break; // valid input
			}
			
			/*
			 * userAttempt++; if(userAttempt>=3) { userAttempt++;
			 * System.out.println("Too many invalid attempts. Exiting..."); return; }
			 */
			
		}
		
		// --- Password with validation ---
		String pass = null;
		while (true) {
			System.out.println("Enter Password : ");
			pass = sc.nextLine().trim();

			// check not empty and letters digit special symbol
			if (pass.isEmpty()) {
				System.out.println("Password cannot be empty. Please tyr again");
				continue;
			}
			if (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$")) {
				System.out.println(
						"Password must contain One Upper and lower case ,digit and at least one special symbol)");
				continue;
			}
			break;

		}
		if (lp.checkingvalidation(userName, pass)) {
			ScoreStoreDB.getScoreData();
			return;
		}
		while (true) {

			System.out.println("User not found...!If you want to register...!(yes/no)");
			String choice = sc.next();
			if (choice.equals("yes")) {
				try {
					RegistrationLoginData isd = new RegistrationLoginData();
					isd.inputStudentData();

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			} else if (choice.equals("no")) {
				System.out.println("Sorry you cannot perform quiz...!");
				break;
			} else {
				System.out.println("Invalid choice...!");

			}
		}

	} /*
		 * catch (Exception e) { e.printStackTrace(); }
		 */

}
