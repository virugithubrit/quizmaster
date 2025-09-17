package com.score;
import java.sql.SQLException;
import java.util.Scanner;

import com.login.LoginPage;
import com.quize.qustions.QuizeQuestions;
import com.register.RegistrationLoginData;
public class ScoreCalculate {
	
	public static void getScore() throws SQLException {
		LoginPage lp = new LoginPage();
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter user name...");
		String name = sc.next();
		System.out.println("Enter password...");
		String pass = sc.next();
		if (lp.checkingvalidation(name,pass)) {
			QuizeQuestions.score();
			return;
		}
		while (true) {

			System.out.println("User not found...!If you want to register...!(yes/no)");
			String choice = sc.next();
			if (choice.equals("yes")) {
				try {
					RegistrationLoginData isd = new RegistrationLoginData();
					isd.inputStudentData();

				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			}
			else if (choice.equals("no")) {
				System.out.println("Sorry you cannot perform quiz...!");
				break;
			}
			else {
				System.out.println("Invalid choice...!");
                
			}
		}

	} /*catch (Exception e) {
		e.printStackTrace();
	} finally {
		sc.close();
	}*/


	}


