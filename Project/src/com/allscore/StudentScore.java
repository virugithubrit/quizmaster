package com.allscore;

public class StudentScore {//View All Student Scores (Admin) (User Story 3.2)

	private int studentId;
	private String firstName;
	private String lastName;
	private int totalScore;
	private String grade;

	public StudentScore(int studentId, String firstName, String lastName, int totalScore, String grade) {
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalScore = totalScore;
		this.grade = grade;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public String getGrade() {
		return grade;
	}
}
