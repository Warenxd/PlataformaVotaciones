package com.example.app.PlataformaVotaciones.entities;

import java.util.List;

public class Question {

    private String text;
    private List<String> options;
    private String selectedAnswer;


    public Question(){

    }

    public Question(String text, List<String> options, String selectedAnswer) {
        this.text = text;
        this.options = options;
        this.selectedAnswer = selectedAnswer;
    }



    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}
