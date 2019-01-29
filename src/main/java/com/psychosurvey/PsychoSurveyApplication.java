package com.psychosurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class PsychoSurveyApplication implements CommandLineRunner {

	@Autowired
	private SurveyManager surveyManager;

	@Autowired
	private ExampleSurvey exampleSurvey;

	private static String username;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//  prompt for the user's name
		System.out.print("Enter your name: ");

		// get their input as a String
		username = scanner.next();

		System.out.println(username);
			SpringApplication.run(PsychoSurveyApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		if (username != null) {
			surveyManager.conductSurvey(exampleSurvey);
		}
	}
}
