package com.crystal.webapplication.models;

public class Questions {
    private  int id;
    private String question_name;
    private String question_by;
    private String answer;
    private String answer_by;
    private int topic_id;

    public int getId() {
        return id;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) {
        this.question_name = question_name;
    }

    public String getQuestion_by() {
        return question_by;
    }

    public void setQuestion_by(String question_by) {
        this.question_by = question_by;
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

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }
}
