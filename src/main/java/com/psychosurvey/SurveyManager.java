package com.psychosurvey;

import com.psychosurvey.questions.Question;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Scanner;

@Component
public class SurveyManager {

    PrintWriter writer = null;

    public void conductSurvey(Survey survey){
        List<Question> questions = survey.getRandomizedQuestions();
        try {
            writer = new PrintWriter("survey.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        questions.forEach(this::askQuestion);
        writer.close();
    }

    private void askQuestion(Question question) {
        System.out.println(question.getQuestion());
        Scanner scanner = new Scanner(System. in);
        String input = scanner.nextLine();
        question.setChosenAnswer(input);
        writer.println(question.getQuestionWithAnswer());
        clearScreen();
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
    }
}
