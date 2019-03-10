package com.psychosurvey.questions;

import java.util.List;
import java.util.stream.IntStream;

public class ChoiceQuestion extends Question {

    List<String> answers;

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public ChoiceQuestion(int id, String questionText, List<String> answers) {
        this.id = id;
        this.questionText = questionText;
        this.answers = answers;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        IntStream.rangeClosed(1, answers.size()).
                forEach(i -> fullQuestion.append("\n" + i +"." + answers.get(i - 1)));
        fullQuestion.append("\n\nPodaj numer Twojej odpowiedzi: ");
        return fullQuestion.toString();
    }



}
