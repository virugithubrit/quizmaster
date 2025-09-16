package com.register;

public class ValidateUserInput {

	public static boolean isNotEmpty(String input) {
		return input != null && !input.trim().isEmpty();
	}

	public static boolean isValidEmail(String email) {
		// it is regex pattern which for validating email in(example-username123@gmail.com)
		return email.matches("^[A-Za-z0-9_%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
	}

	public static boolean isValidPassword(String password) {
		// at least 6 characters
		return password.length() >= 6;
	}

	public static boolean isValidMobile(String mobile) {
		// exactly 10 digits
		return mobile.matches("^[0-9]{10}$");
	}

}
