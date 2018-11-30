package com.psychosurvey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PsychoSurveyApplication implements CommandLineRunner {

//	private final FileChooser fileChooser;

	private ExemplarOfJustice knightOfJustice;

	private ExemplarOfJustice angelOfJustice;

	@Autowired
	@Qualifier("knight")
	public void setKnightOfJustice(ExemplarOfJustice knightOfJustice){
		this.knightOfJustice = knightOfJustice;
	}

	@Autowired
	@Qualifier("angel")
	public void setAngelOfJustice(ExemplarOfJustice angelOfJustice){
		this.angelOfJustice = angelOfJustice;
	}

//	public PsychoSurveyApplication(ExemplarOfJustice knightOfJustice, ExemplarOfJustice angelOfJustice) {
//		this.knightOfJustice = knightOfJustice;
//		this.angelOfJustice  = angelOfJustice;
//	}

	public static void main(String[] args) {
		SpringApplication.run(PsychoSurveyApplication.class, args);
	}

	@Override
	public void run(String[] args) {
		knightOfJustice.bringJustice();
		angelOfJustice.bringJustice();
	}
}
