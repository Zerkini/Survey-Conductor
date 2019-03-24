package com.psychosurvey.questions;

public class IntroductoryQuestion extends Question {

    public IntroductoryQuestion() {
        this.id = 0;
    }

    @Override
    public String getQuestion() {
        return "Podaj swoje inicjaly";
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }
}
