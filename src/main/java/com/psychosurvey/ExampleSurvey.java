package com.psychosurvey;

import com.psychosurvey.questions.Question;

import java.util.ArrayList;
import java.util.Collections;

public class ExampleSurvey {

        private ArrayList<Question> questions = new ArrayList<>();

    {questions.add()}

        public ArrayList<Question> getRandomizedQuestions(){
            Collections.shuffle(questions);
            return questions;
        }

}
