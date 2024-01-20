package zerkinisoft;

import zerkinisoft.questions.Question;

import java.util.Collections;
import java.util.List;

public class Survey {

    List<Question> questions;

    public Survey(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getRandomizedQuestions(){
        Collections.shuffle(questions);
        return questions;
    }

}
