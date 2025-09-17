package com.login;

import java.util.Scanner;
import com.register.UserRegisterData;

public class InputLoginData {

	public static void getLogin() {
		UserRegisterData srd = new UserRegisterData();
		// create the object of scanner class
		Scanner sc = new Scanner(System.in);
		String userName = null;
		while (true) {
			System.out.println("Enter Username : ");
			userName = sc.nextLine().trim();

			// check not empty and letters and alphabet only
			if (userName.isEmpty()) {
				System.out.println("User name cannot be empty. Please try again.");
				continue;
			}
			if (!userName.matches("^[A-Za-z][A-Za-z0-9_]{2,19}")) {
				System.out.println("User name must contain letters,digits,dot(.) and underScore(_). Please try again.");
				continue;
			}
			break; // valid input
		}
		srd.setUserName(userName);
		String pass = null;
		while (true) {
			System.out.println("Enter Password : ");
			pass = sc.nextLine().trim();

			// check not empty and letters digit special symbol
			if (pass.isEmpty()) {
				System.out.println("Password cannot be empty. Please tyr again");
				continue;
			}
			if (!pass.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{8,20}$")) {
				System.out.println("Password must be contain One Upper and lower case ,digit and special symbol");
				continue;
			}
			break;

		}
		// -----checking for login-------//

		srd.setPassword(pass);
		LoginPage lp = new LoginPage();
		if (lp.getUserData(srd)) {
			System.out.println("Login successfully!");
		} else {
			System.out.println("Invalid username or password!");
			
		}
		
	}
	

}
