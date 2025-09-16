package com.velocity.quizmaster.deletequestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DeleteQuestion {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/quizmaster";
	private static final String DB_USERNAME = "root";
	private static final String DB_PASSWORD = "Root";

	// Get database connection
	public static Connection getConnection() throws ClassNotFoundException {
		Connection conn = null;
		try {
			// Loading the driver
			Class.forName(DB_DRIVER);

			// Establish connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection failed: " + e.getMessage());
		}
		return conn;
	}

	// delete question by ID
	public static void deleteQuestionById() throws ClassNotFoundException {
		Scanner scanner = new Scanner(System.in);

		try (Connection conn = getConnection()) {

			System.out.print("Enter Question Id to delete: ");
			int questionId = scanner.nextInt();
			scanner.nextLine(); // for new line

			// check if question exists
			String checkQuery = "select * from question where id=?";
			PreparedStatement psCheck = conn.prepareStatement(checkQuery);
			psCheck.setInt(1, questionId);// set questionId in the query
			ResultSet rs = psCheck.executeQuery();

			if (!rs.next()) {// if no record found
				System.out.println("Question with Id " + questionId + " does not exist.");
				return;
			}

			System.out.print("Are you sure you want to delete this question? (Y/N): ");
			String confirm = scanner.next();
			if (confirm.equalsIgnoreCase("Y")) {
				String deleteQuery = "delete from question where id=?";

				PreparedStatement psDelete = conn.prepareStatement(deleteQuery);
				psDelete.setInt(1, questionId);// set the id for deletion

				// Submit SQL statement to Database
				int rows = psDelete.executeUpdate();

				// Process the results
				if (rows > 0)// one row was deleted.
					System.out.println("Question deleted successfully!");
				else
					System.out.println("Failed to delete question.");

			} else {
				System.out.println("Deletion cancelled.");// if user don't want to delete question
			}

		} catch (SQLException e) {
			System.out.println("Database Error: " + e.getMessage());
		} catch (InputMismatchException e) {
			System.out.println("Error: Please enter only Id.");
		} finally {
			scanner.close();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException {
		deleteQuestionById();
	}

}
