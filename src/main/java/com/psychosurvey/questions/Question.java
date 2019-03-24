package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public abstract class Question implements Comparable<Question>{
    String questionText;
    String chosenAnswer;
    int id;

    public abstract String getQuestion();

    public abstract void setChosenAnswer(String chosenAnswer);

    public int getId() {
        return id;
    }

    public String getQuestionWithAnswer(){
        StringBuilder questionWithAnswer = new StringBuilder(getQuestion());
        questionWithAnswer.append("\nOdpowiedz:\n" + this.chosenAnswer);
        return questionWithAnswer.toString();
    }

    @Override
    public int compareTo(Question question) {
        if(this.id < question.getId()){
            return -1;
        }
        else if (this.id == question.getId()){
            return 0;
        }
        else return 1;
    }
}
