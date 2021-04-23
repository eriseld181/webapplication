package com.crystal.webapplication.controllers;
import com.crystal.webapplication.models.Topics;
import com.crystal.webapplication.repositories.TopicsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicsController {
    @Autowired
    private TopicsRepository topicsRepository;

    @GetMapping
    public List<Topics> list() {


        return topicsRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Topics get(@PathVariable Long id) {
        return topicsRepository.getOne(id);
    }

    @PostMapping
    public Topics create(@RequestBody Topics topics){

        return topicsRepository.saveAndFlush(topics);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        topicsRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Topics update(@PathVariable Long id, @RequestBody Topics topics) {
        Topics existingTopics = topicsRepository.getOne(id);
        BeanUtils.copyProperties(topics, existingTopics, "to_id");
        return topicsRepository.saveAndFlush(existingTopics);
    }

}
