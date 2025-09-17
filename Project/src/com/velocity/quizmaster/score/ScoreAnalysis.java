package com.velocity.quizmaster.score;

public class ScoreAnalysis {

	public static String calculateGradeAndMessage(int score) {

		String grade;
		String message;

		if (score >= 8) {
			// if score is 8 or above = Excellent performance
			grade = "A";
			message = "Excellent";
		} else if (score >= 5) {
			// if score is between 5 and 7 = Good performance
			grade = "B";
			message = "Good";
		} else {
			// if score is less than 5 = Needs Improvement
			grade = "C";
			message = "Needs Improvement";
		}

		// Display to student
		System.out.println("=== Quiz Result ===");
		System.out.println("Your Score: " + score + " / 10");
		System.out.println("Your Grade: " + grade);
		System.out.println("Feedback: " + message);

		return grade; // return grade for DB storage

	}

}
