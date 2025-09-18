package com.register;

import java.util.Scanner;
import com.login.InputLoginData;
import com.login.LoginPage;

public class CheckValidation {

	void checkingValidation() {
		Scanner sc = new Scanner(System.in);
		try {
			LoginPage lp = new LoginPage();
			String boldText = "\033[1m!---Welcome to Quiz Based Application---!\033[0m";
			System.out.println(boldText);
			System.out.println("Enter user name...");
			String name = sc.next();
			if (lp.checkingvalidation(name)) {
				System.out.println("Your already register..!");
				InputLoginData.getLogin();
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
				}
				else if (choice.equals("no")) {
					System.out.println("Sorry you cannot perform quiz...!");
					System.exit(0);
					
				}
				else {
					System.out.println("Invalid choice...!");
                    
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} 

	}
}
