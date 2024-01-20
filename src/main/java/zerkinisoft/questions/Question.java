package zerkinisoft.questions;

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
        return getQuestion() + "\nOdpowiedz:\n" + this.chosenAnswer;
    }

    @Override
    public int compareTo(Question question) {
        return Integer.compare(this.id, question.getId());
    }
}
