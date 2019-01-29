package com.psychosurvey.questions;

public class ScaleQuestion extends Question {

    int maxScale;

    public ScaleQuestion(String questionText, int maxScale) {
        this.questionText = questionText;
        this.maxScale = maxScale;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nEnter an integer from 1 to ");
        fullQuestion.append(maxScale);
        return fullQuestion.toString();
    }

}
