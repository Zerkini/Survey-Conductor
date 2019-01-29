package com.psychosurvey.questions;

public class TextQuestion extends Question {

    public TextQuestion(String questionText) {
        this.questionText = questionText;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nWrite your answer: ");
        return fullQuestion.toString();
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

}
