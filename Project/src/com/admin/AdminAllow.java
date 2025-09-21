
package com.admin;

import java.sql.SQLException;
import java.util.Scanner;

public class AdminAllow {

	public static void getAdminAllow(Scanner sc) throws ClassNotFoundException, SQLException {

		final String ADMIN_USER = "Admin_1234";
		final String ADMIN_PASS = "Success@1234";

		String userName;
		String password;

		// === Username check ===
		while (true) {
			System.out.print("Enter Username : ");
			userName = sc.nextLine().trim();

			if (userName.isEmpty() || !userName.equals(ADMIN_USER)) {
				System.out.println("Invalid username. Please try again.");
			} else {
				break; // valid username
			}
		}

		// === Password check ===
		while (true) {
			System.out.print("Enter Password : ");
			password = sc.nextLine().trim();

			if (password.isEmpty() || !password.equals(ADMIN_PASS)) {
				System.out.println("Invalid password. Please try again.");
			} else {
				break; // valid password
			}
		}

		// === Successful login ===
		AdminPanel ap = new AdminPanel();
		ap.adminControl();
	}

}
