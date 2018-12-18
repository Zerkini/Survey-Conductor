package com.psychosurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsychoSurveyApplication implements CommandLineRunner {

	@Autowired
	private FileChooser fileChooser;

	public static void main(String[] args) {
		SpringApplication.run(PsychoSurveyApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		fileChooser.chooseFile();
	}
}
