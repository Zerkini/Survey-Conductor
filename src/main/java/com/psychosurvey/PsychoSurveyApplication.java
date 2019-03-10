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
	private FileChooser fileChooser;

	private static String username;


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your name: ");
		username = scanner.next();
		System.err.close();
		System.setErr(System.out);
		SpringApplication.run(PsychoSurveyApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		if (username != null) {
			surveyManager.conductSurvey(fileChooser.chooseFile(), username);
		}
	}
}

