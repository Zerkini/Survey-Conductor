package zerkinisoft.questions;

public class TextQuestion extends Question {

    public TextQuestion(int id, String questionText) {
        this.id = id;
        this.questionText = questionText;
    }

    @Override
    public String getQuestion() {
        return questionText + "\n\nNapisz swoja odpowiedz: ";
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

}
