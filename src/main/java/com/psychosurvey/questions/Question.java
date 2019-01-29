package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public abstract class Question {
    String questionText;
    String chosenAnswer;

    public abstract String getQuestion();

    public abstract void setChosenAnswer(String chosenAnswer);

    public String getQuestionWithAnswer(){
        StringBuilder questionWithAnswer = new StringBuilder(getQuestion());
        questionWithAnswer.append("\nAnswer:\n" + this.chosenAnswer);
        return questionWithAnswer.toString();
    }

}
