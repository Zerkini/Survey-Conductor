//package com.psychosurvey;
//
//import com.psychosurvey.questions.ChoiceQuestion;
//import com.psychosurvey.questions.Question;
//import com.psychosurvey.questions.ScaleQuestion;
//import com.psychosurvey.questions.TextQuestion;
//import org.springframework.stereotype.Component;
//
//import java.util.Arrays;
//import java.util.List;
//
//@Component
//public class ExampleSurvey extends Survey {
//
//    public ExampleSurvey() {
//        ScaleQuestion scaleQuestion1 = new ScaleQuestion("This is a scale question\n", 5);
//        TextQuestion textQuestion1 = new TextQuestion("This is a TEXT question\n");
//        List<String> answersForChoiceQuestion1 = Arrays.asList(new String[]{"answer1\n", "answer2\n", "answer3\n"});
//        ChoiceQuestion choiceQuestion1 = new ChoiceQuestion("This is a CHOICE question\n", answersForChoiceQuestion1);
//        this.questions= Arrays.asList(new Question[]{scaleQuestion1, textQuestion1, choiceQuestion1});
//    }
//}
