package zerkinisoft;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class SurveyConductorApplication extends JFrame {

	private static SurveyManager surveyManager;
	private static FileChooser fileChooser;
	private static zerkinisoft.Window window;

	public SurveyConductorApplication(FileChooser fileChooser, SurveyManager surveyManager, Window window){
		SurveyConductorApplication.fileChooser = fileChooser;
		SurveyConductorApplication.surveyManager = surveyManager;
		SurveyConductorApplication.window = window;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(SurveyConductorApplication.class)
				.headless(false).run(args);

		EventQueue.invokeLater(() -> {
			SurveyConductorApplication ex = ctx.getBean(SurveyConductorApplication.class);
		});
		surveyManager.conductSurvey(fileChooser.chooseFile(), window);
	}
}