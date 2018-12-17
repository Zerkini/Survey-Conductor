package com.psychosurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsychoSurveyApplication implements CommandLineRunner {

	private FileChooser fileChooser;

	@Autowired
	public void setFileChooser(FileChooser fileChooser){
		this.fileChooser = fileChooser;
	}

	public static void main(String[] args) {
		SpringApplication.run(PsychoSurveyApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		fileChooser.chooseFile();
	}
}
