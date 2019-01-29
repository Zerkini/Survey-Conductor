package com.psychosurvey.questions;

import java.util.List;

import static java.lang.Integer.parseInt;

public class ChoiceQuestion extends Question {

    List<String> answers;

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public ChoiceQuestion(String questionText, List<String> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        answers.forEach(fullQuestion::append);
        fullQuestion.append("\n\nEnter an integer corresponding to your answer: ");
        return fullQuestion.toString();
    }

}
