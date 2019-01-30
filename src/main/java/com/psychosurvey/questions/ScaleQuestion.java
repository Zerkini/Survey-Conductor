package com.psychosurvey.questions;

public class ScaleQuestion extends Question {

    int maxScale;

    public ScaleQuestion(int id, String questionText, int maxScale) {
        this.id = id;
        this.questionText = questionText;
        this.maxScale = maxScale;
    }

    public String getChosenAnswer() {
        return chosenAnswer;
    }

    public void setChosenAnswer(String chosenAnswer) {
        this.chosenAnswer = chosenAnswer;
    }

    @Override
    public String getQuestion() {
        StringBuilder fullQuestion = new StringBuilder(questionText);
        fullQuestion.append("\n\nOceń i wpisz liczbę, na ile prawdopodobne jest wystąpienie poniższych sytuacji. \n" +
                "Jeden (1) oznacza sytuację mało prawdopodobną, a dziesięć (" + maxScale + ") sytuację bardzo prawdopodobną.");
        fullQuestion.append(maxScale);
        return fullQuestion.toString();
    }

}
