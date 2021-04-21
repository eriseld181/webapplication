package com.crystal.webapplication.dto;

public class answerDTO {
    private int id;
    private String  answer;
    private String answer_by;

    public int getId() {
        return id;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer_by() {
        return answer_by;
    }

    public void setAnswer_by(String answer_by) {
        this.answer_by = answer_by;
    }
}
