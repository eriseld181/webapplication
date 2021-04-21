package com.crystal.webapplication.models;

public class Topic {
    public int getTopic_id() {
        return topic_id;
    }


    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

    private int topic_id;
    private String topic_name;
}
