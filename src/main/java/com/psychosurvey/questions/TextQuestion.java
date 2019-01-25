package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public class TextQuestion extends Question {

    String answer;

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nWrite your answer: ");
        return fullQuestion.toString();
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
