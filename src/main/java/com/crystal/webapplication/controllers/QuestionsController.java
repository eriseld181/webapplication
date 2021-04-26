package com.crystal.webapplication.controllers;
import com.crystal.webapplication.models.Questions;
import com.crystal.webapplication.services.QuestionsService;
import com.crystal.webapplication.services.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionsController {
    @Autowired
    private QuestionsService questionsService;


    @GetMapping
    public ResponseEntity<List<Questions>> list() {
        if(questionsService.list().isEmpty())
            return  new ResponseEntity("There is no question in database.",HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.OK).body(questionsService.list());
    }

        @GetMapping("{id}")
    public  ResponseEntity<Questions> get(@PathVariable Long id){
    if(questionsService.existById(id)) {
        return ResponseEntity.status(HttpStatus.OK).body(questionsService.getOneRecord(id));
    }else
            return  new ResponseEntity("Question not found.",HttpStatus.BAD_REQUEST);
        }

    @PostMapping
    public ResponseEntity create(@RequestBody final Questions questions) {
        try {
            questionsService.createQuestions(questions);
            return new ResponseEntity("Question added succesfully.", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity("Error: question cant be added.", HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            questionsService.deleteQuestions(id);
            return new ResponseEntity("Question deleted succesfully.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("Error: question dofesn't exist.", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Questions questions) {
        try {
            questionsService.update(id, questions);
            return new ResponseEntity("Question is updated.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("Error:   question can not be updated.", HttpStatus.SEE_OTHER );
        }
    }

    @PutMapping(value = "/updateResponse/{id}")
    public ResponseEntity updateResponse(@PathVariable(value = "id") Long id, @RequestBody Questions questions) {
      try {
          questionsService.updateResponse(id, questions);
          return new ResponseEntity("Question  response is updated.", HttpStatus.OK);
      }
      catch (Exception ex){
          return new ResponseEntity("Error: response can not be updated.", HttpStatus.BAD_REQUEST);
      }
    }

    @DeleteMapping("/deleteNotAnswered/{id}")
    public ResponseEntity deleteNotAnswered(@PathVariable(value = "id") Long id) {
        try{
        questionsService.deleteNotAnswered(id);
            return new ResponseEntity("Questions without response deleted succesfully.", HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity("All questions has response ,no question deleted.", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getNotAnswered")
    public ResponseEntity<List<String>> getNotAnswered() {
        if (questionsService.getNotAnswered().isEmpty())
            return new ResponseEntity("There is no question without answer.", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.OK).body(questionsService.getNotAnswered());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<List<Questions>> listNotAnsweredById(@PathVariable Long id) {
        if (questionsService.findNotAnsweredByTopicId(id).isEmpty())
            return new ResponseEntity("There is no question without answer for this topic.", HttpStatus.BAD_REQUEST);
        return ResponseEntity.status(HttpStatus.OK).body(questionsService.findNotAnsweredByTopicId(id));
    }
}
