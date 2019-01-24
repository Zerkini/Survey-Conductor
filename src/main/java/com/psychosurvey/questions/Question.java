package com.psychosurvey.questions;

import org.springframework.stereotype.Component;

@Component
public abstract class Question {
    String questionText;

    public abstract String getQuestion();

}
