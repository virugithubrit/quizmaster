package com.velocity.quizmaster.score;

public class GradeCalculate {
	
	public static String calculateGrade(int score) {
        String grade;
        String message;

        if (score >= 8) {
            grade = "A";
            message = "Excellent";
        } else if (score >= 5) {
            grade = "B";
            message = "Good";
        } else {
            grade = "C";
            message = "Needs Improvement";
        }

        // Display feedback to student
        System.out.println("=== Quiz Result ===");
        System.out.println("Your Score: " + score + " / 10");
        System.out.println("Your Grade: " + grade);
        System.out.println("Feedback: " + message);

        return grade; // returned to save in DB
    }

}
