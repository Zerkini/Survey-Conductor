package com.psychosurvey.questions;

public class TextQuestion extends Question {

    public TextQuestion(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nNapisz swoja odpowiedz: ");
        return fullQuestion.toString();
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

}
