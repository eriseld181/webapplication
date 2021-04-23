package com.crystal.webapplication.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.List;

@Entity(name="topics")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Topics {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long to_id;
    private String topic_name;
    @OneToMany(targetEntity=Questions.class, mappedBy="topics" )
    @JsonIgnore
    private List<Questions> questions;
    public Topics() {
    }


    public void setQuestions(List<Questions> questions) {
        this.questions = questions;
    }

    public List<Questions> getQuestions() {
        return questions;
    }
    public Long getTo_id() {
        return to_id;
    }

    public void setTo_id(Long to_id) {
        this.to_id = to_id;
    }

    public String getTopic_name() {
        return topic_name;
    }

    public void setTopic_name(String topic_name) {
        this.topic_name = topic_name;
    }

}