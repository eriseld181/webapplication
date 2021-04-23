package com.crystal.webapplication.services;

import com.crystal.webapplication.models.Topics;
import com.crystal.webapplication.repositories.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicsService {
    @Autowired
    private TopicsRepository  topicsRepository;
    public List<Topics> list(){
        return  topicsRepository.findAll();
    }

}
