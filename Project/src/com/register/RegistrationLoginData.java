package com.register;

import java.util.Scanner;

public class RegistrationLoginData {

	public void inputStudentData() {
		UserRegisterData srd = new UserRegisterData();
		// create the scanner class object
		Scanner sc = new Scanner(System.in);
		// --- First name with validation ---
		String firstName = null;
		while (true) {
			System.out.print("Enter First Name: ");
			firstName = sc.nextLine().trim();

			// Check not empty and letters only
			if (firstName.isEmpty()) {
				System.out.println("First name cannot be empty. Please try again.");
				continue;
			}
			if (!firstName.matches("[A-Za-z]+")) {
				System.out.println("First name must contain only letters. Please try again.");
				continue;
			}
			break; // valid input
		}
		srd.setFirstName(firstName);
		// --- Last name with validation ---
		String lastName = null;
		while (true) {
			System.out.println("Enter Last Name : ");
			lastName = sc.nextLine().trim();

			// check not empty and letters only
			if (lastName.isEmpty()) {
				System.out.println("Last name cannot be empty. Please try again.");
				continue;
			}
			if (!lastName.matches("[A-Za-z]+")) {
				System.out.println("Last name must contain only letters. Please try again.");
				continue;
			}
			break; // valid input
		}
		srd.setLastName(lastName);
		// --- User name with validation ---
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
				System.out.println("User name must contain letters,digits and underScore(_). Please try again.");
				continue;
			}
			break; // valid input
		}
		srd.setUserName(userName);
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
				System.out.println("Password must contain One Upper and lower case ,digit and at least one special symbol)");
				continue;
			}
			break;

		}
		srd.setPassword(pass);
		// ---City with validation ---
		String city = null;
		while (true) {
			System.out.println("Enter City : ");
			city = sc.nextLine().trim();

			// Check not empty and letters only
			if (city.isEmpty()) {
				System.out.println("city cannot be empty. Please try again.");
				continue;
			}
			if (!city.matches("[A-Za-z]+")) {
				System.out.println("city must contain only letters. Please try again.");
				continue;
			}
			break; // valid input
		}
		srd.setCity(city);
		// --- email with validation ---
		String email = null;
		while (true) {
			System.out.println("Enter Email ID : ");
			email = sc.nextLine().trim();

			// Check not empty and abc123@gmail.com
			if (email.isEmpty()) {
				System.out.println("email cannot be empty. Please try again.");
				continue;
			}
			if (!email.matches( "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
				System.out.println("Email Id contain abc123@gmail.com. Please try again");
				continue;
			}
			break; // valid input
		}
		srd.setEmailId(email);
		// --- Mobile Number with validation ---
		String mobile = null;
		while (true) {
			System.out.println("Enter Mobile Number : ");
			mobile = sc.nextLine().trim();

			// check not empty and letters and alphabet only
			if (mobile.isEmpty()) {
				System.out.println("Mobile number can't be empty. Please try again.");
				continue;
			}
			if (!mobile.matches("^[6-9]\\d{9}$")) {
				System.out.println("Mobile number must be contain 10 digit & first digit must be 6–9");
				continue;
			}
			break;
		}
		srd.setMobileNumber(mobile);
		//--- creating object of RegistrationPage -----
		RegistrationPage rp = new RegistrationPage();
		//System.out.println("I am from input");
		//!--- calling the method saveStudent and pass the (object)srd to save the user data into db ---!
		rp.saveStudent(srd);
		sc.close();

	}
	

}
