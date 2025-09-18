package com.quize.qustions;

import java.sql.SQLException;

public class Main {
	
	public static void main(String[] args) {
        try {
            // Call quiz start
            QuizeQuestions.getQuizeQuestions();
            
            // After quiz, show score & grade
            QuizeQuestions.score();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
