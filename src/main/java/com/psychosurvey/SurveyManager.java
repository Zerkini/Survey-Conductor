package com.psychosurvey;

import com.psychosurvey.questions.Question;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

@Component
public class SurveyManager {

    PrintWriter writer = null;

    public void conductSurvey(Survey survey, String username){
        List<Question> questions = survey.getRandomizedQuestions();

        questions.forEach(this::askQuestion);
        try {
            writer = new PrintWriter("survey.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Collections.sort(questions);
        writer.println(username + "\n");
        questions.forEach(question -> writer.println(question.getQuestionWithAnswer() + "\n"));
        writer.close();
        System.exit(0);
    }

    private void askQuestion(Question question) {
        System.out.println(question.getQuestion());
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        question.setChosenAnswer(input);
//        clearScreen();
    }

    private static void clearScreen() {
//        System.out.print("\033[H\033[2J");
        try {
            Runtime.getRuntime().exec("cls");
        } catch (IOException e) {
            IntStream.rangeClosed(1, 100).forEach(i -> System.out.println());
        }
    }


}
