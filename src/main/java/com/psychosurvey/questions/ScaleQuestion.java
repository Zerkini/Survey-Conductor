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
        fullQuestion.append("\n\nOcen i wpisz liczbe, na ile prawdopodobne jest wystapienie ponizszych sytuacji. \n" +
                "Jeden (1) oznacza sytuacje malo prawdopodobna, a dziesiec (" + maxScale + ") sytuacje bardzo prawdopodobna.");
        return fullQuestion.toString();
    }

}
