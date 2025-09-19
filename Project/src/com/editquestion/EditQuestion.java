package com.editquestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.register.RegistrationPage;

public class EditQuestion {


	public void editExistingQuestion() {
		Scanner scanner = new Scanner(System.in);
		try {
			Connection conn =RegistrationPage.getConnection();

			System.out.println("Enter Question Id to edit : ");
			int id = scanner.nextInt();
			scanner.nextLine();
			// query to check if the question exists in DB
			String checkQuery = "select * from question where id = ?";
			PreparedStatement psCheck = conn.prepareStatement(checkQuery);
			psCheck.setInt(1, id);// set the id value in query

			// query to check if the record exists
			ResultSet rs = psCheck.executeQuery();

			if (!rs.next()) {
				System.out.println("Question with Id " + id + " does not exist.");
				return;// stop execution
			}

			System.out.println("Enter new question text : ");
			String text = scanner.nextLine();

			System.out.println("Enter New Option 1: ");
			String op1 = scanner.nextLine();

			System.out.println("Enter New Option 2: ");
			String op2 = scanner.nextLine();

			System.out.println("Enter New Option 3: ");
			String op3 = scanner.nextLine();

			System.out.println("Enter New Option 4: ");
			String op4 = scanner.nextLine();

			System.out.println("Enter New Correct Option (1-4): ");
			int correct = scanner.nextInt();
			// correct option must be between 1 and 4
			if (correct < 1 || correct > 4) {
				System.out.println("Invalid choice! Correct option must be between 1 and 4.");
				return; // stop execution without updating
			}

			// query to edit the question
			String updateQuery = "update question set question_text=?, option1=?, option2=?, "
					+ "option3=?, option4=?, correct_option=? where id=?";
			// set new values
			PreparedStatement psUpdate = conn.prepareStatement(updateQuery);
			psUpdate.setString(1, text);
			psUpdate.setString(2, op1);
			psUpdate.setString(3, op2);
			psUpdate.setString(4, op3);
			psUpdate.setString(5, op4);
			psUpdate.setInt(6, correct);
			psUpdate.setInt(7, id);

			// Submit SQL statement to Database
			int rows = psUpdate.executeUpdate();

			// Process the results
			if (rows > 0) {// row was updated
				System.out.println("Question updated successfully!");
			} else {
				System.out.println("Failed to update question.");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter only Id.");
		}
	}

}