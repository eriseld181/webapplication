package com.crystal.webapplication.controllers;

import com.crystal.webapplication.dto.QuestionsDTO;
import com.crystal.webapplication.models.Questions;
import com.crystal.webapplication.services.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;
private QuestionsDTO questionsDTO;
    @GetMapping
    public List<Questions> list(){
      return questionsService.list();
    }

//    @GetMapping("{id}")
//    public  Questions get(@PathVariable Long id){
//       return questionsService.getOneRecord(id);
//    }
    @PostMapping
    public Questions create(@RequestBody final Questions questions){
        return questionsService.createQuestions(questions);
    }
    @DeleteMapping(value = "{id}" )
    public void delete(@PathVariable Long id) {
        questionsService.deleteQuestions(id);
    }

    @PutMapping(value = "/update/{id}" )
    public Questions update(@PathVariable Long id, @RequestBody Questions questions) {

        return questionsService.update(id,questions);
    }
    @PutMapping(value = "/updateResponse/{id}" )
    public Questions updateResponse(@PathVariable (value="id") Long id,@RequestBody Questions questions){
        return  questionsService.updateResponse(id,questions);
    }
    @DeleteMapping("/deleteNotAnswered/{id}")
    public void deleteNotAnswered(@PathVariable (value="id")  Long id) {
        questionsService.deleteNotAnswered(id);
    }
    @GetMapping("/getNotAnswered")
    public List<String> getNotAnswered(){
        return questionsService.getNotAnswered();
    }
    @GetMapping("/findById/{id}")
    public List<Questions> listNotAnsweredById( @PathVariable Long id){
        return questionsService.findNotAnsweredByTopicId(id);
    }

}
