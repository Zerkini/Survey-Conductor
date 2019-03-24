package com.psychosurvey;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class PsychoSurveyApplication extends JFrame{


	private static SurveyManager surveyManager;
	private static FileChooser fileChooser;
	private static Window window;

	public PsychoSurveyApplication(FileChooser fileChooser, SurveyManager surveyManager, Window window){
		PsychoSurveyApplication.fileChooser = fileChooser;
		PsychoSurveyApplication.surveyManager = surveyManager;
		PsychoSurveyApplication.window = window;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(PsychoSurveyApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			PsychoSurveyApplication ex = ctx.getBean(PsychoSurveyApplication.class);
		});
		surveyManager.conductSurvey(fileChooser.chooseFile(), window);
	}
}