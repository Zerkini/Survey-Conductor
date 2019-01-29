package com.psychosurvey;

import com.psychosurvey.questions.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Survey {

    List<Question> questions = new ArrayList<>();

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getRandomizedQuestions(){
        Collections.shuffle(questions);
        return questions;
    }

}
