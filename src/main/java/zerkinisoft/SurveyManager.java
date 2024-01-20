package zerkinisoft;

import zerkinisoft.questions.IntroductoryQuestion;
import zerkinisoft.questions.Question;
import org.springframework.stereotype.Component;

import javax.swing.JFrame;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.List;

@Component
public class SurveyManager extends JFrame {

    private PrintWriter writer = null;
    private int questionIndex = 0;
    private List<Question> questions;


    public void conductSurvey(Survey survey, Window window){
        window.setSurveyManager(this);
        questions = survey.getRandomizedQuestions();
        IntroductoryQuestion introductoryQuestion = new IntroductoryQuestion();
        questions.add(0, introductoryQuestion);
        nextQuestion(questions.get(questionIndex));
    }

    private void finishSurvey(List<Question> questions){
        try {
            writer = new PrintWriter("badanie-wynik.txt", "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Collections.sort(questions);
        questions.forEach(question -> writer.println(question.getQuestionWithAnswer() + "\n"));
        writer.close();
        System.exit(0);
    }

    private void nextQuestion(Question question) {
        System.out.println(question.getQuestion());
    }

    public void receiveAnswer(String text) {
        Question question = questions.get(questionIndex);
        question.setChosenAnswer(text);
        questionIndex++;
        if(this.questionIndex == questions.size()){
            finishSurvey(questions);
        }
        else{
            nextQuestion(questions.get(questionIndex));
        }
    }
}
