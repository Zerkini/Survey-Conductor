package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public class ScaleQuestion extends Question {

    int maxScale;
    int answer;

    public ScaleQuestion(int maxScale) {
        this.maxScale = maxScale;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);

        return "";
    }
}
