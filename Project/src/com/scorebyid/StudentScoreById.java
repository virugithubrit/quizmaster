package com.scorebyid;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.register.RegistrationPage;

public class StudentScoreById {// Search Student Score by ID (User Story 3.3)

	public void getScoreById() {
		String query = "SELECT total_score, grade FROM score WHERE student_id = ?";
        Scanner sc=new Scanner(System.in);
		try {
            
			Connection conn = RegistrationPage.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Enter Student Id to fetch their record");
			int studentId=sc.nextInt();
			sc.nextLine(); // consume the '\n' new changes from patidev
			ps.setInt(1, studentId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				int score = rs.getInt("total_score");
				String grade = rs.getString("grade");

				System.out.println("Score: " + score);
				System.out.println("Grade: " + grade);
			} else {
				System.out.println("No record found for Student ID: " + studentId);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
