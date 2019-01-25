package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public class ScaleQuestion extends Question {

    int maxScale;
    int answer;

    public ScaleQuestion(int maxScale) {
        this.maxScale = maxScale;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nEnter an integer from 1 to ");
        fullQuestion.append(maxScale);
        return fullQuestion.toString();
    }
}
