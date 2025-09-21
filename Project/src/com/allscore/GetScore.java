package com.allscore;

import java.sql.SQLException;
import java.util.List;

public class GetScore {

	// --View All Student Scores (Admin) (User Story 3.2)--
	public void getAllScore() throws SQLException {

		GetStudentInfo gs = new GetStudentInfo();
		List<StudentScore> studentScores = gs.getAllStudentScores();

		System.out.println("------ All Student Scores (Sorted In Ascending Order) ------");
		System.out.printf("%-5s %-15s %-15s %-10s %-10s%n", "ID", "First Name", "Last Name", "Score", "Grade");
		System.out.println("---------------------------------------------------");

		for (StudentScore ss : studentScores) {
			System.out.printf("%-5d %-15s %-15s %-10d %-10s%n", ss.getStudentId(), ss.getFirstName(), ss.getLastName(),
					ss.getTotalScore(), ss.getGrade());
		}

	}

}
