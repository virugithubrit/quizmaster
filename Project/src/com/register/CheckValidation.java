package com.register;

import java.util.Scanner;
import com.login.InputLoginData;
import com.login.LoginPage;
import com.score.ScoreStoreDB;

public class CheckValidation {

	// --This method used to check validation if user present or not --//
	public static int checkingValidation() {
		Scanner sc = new Scanner(System.in);
		int id=0;
		try {
			LoginPage lp = new LoginPage();
			String boldText = "\033[1m!---Welcome to Quiz Based Application---!\033[0m";
			System.out.println(boldText);
			System.out.println("Enter user name...");
			String name = sc.next();
			if (lp.checkingvalidation(name)) {
				System.out.println("Your already register..!");
				InputLoginData.getLogin(); // getlogin() method..if user already login then used
				 id=ScoreStoreDB.fetchStudentId(name);
				return id;
			}
			while (true) {

				System.out.println("User not found...!If you want to register...!(yes/no)");
				String choice = sc.next();
				if (choice.equals("yes")) {
					try {
						// inputStudentData() method..if user not login login then used
						RegistrationLoginData isd = new RegistrationLoginData();
						String name1=isd.inputStudentData();
						id=ScoreStoreDB.fetchStudentId(name1);
                         System.out.println("registe"+id);
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				} else if (choice.equals("no")) {
					System.out.println("Sorry you cannot perform quiz...!");
					System.exit(0);

				} else {
					System.out.println("Invalid choice...!");

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// int id=ScoreStoreDB.fetchId(name);
		return id;

	}
}
