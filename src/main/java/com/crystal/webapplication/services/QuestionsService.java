package com.crystal.webapplication.services;
import com.crystal.webapplication.models.Questions;
import com.crystal.webapplication.repositories.QuestionsRepository;
import com.crystal.webapplication.repositories.TopicsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QuestionsService {
    @Autowired

    private QuestionsRepository questionsRepository;
    private TopicsRepository topicsRepository;

    public List<Questions> list(){
        return questionsRepository.findAll();
    }

    public  Questions getOneRecord(Long id){
        return questionsRepository.getOne(id);
    }

    public Questions createQuestions(Questions questions){
        return questionsRepository.saveAndFlush(questions);
    }
    //standart
    public void deleteQuestions(Long id ){
        questionsRepository.deleteById(id);
    }
    //standart
    public Questions update(Long id,Questions questions){
        Questions existingQuestions=questionsRepository.getOne(id);
        BeanUtils.copyProperties(questions,existingQuestions,"id");
        return questionsRepository.saveAndFlush(existingQuestions);
    }
    public Questions updateResponse(Long id, Questions questions ){
        Questions existingQuestions= questionsRepository.getOne(id);
        existingQuestions.setAnswer(questions.getAnswer());
        existingQuestions.setAnswer_by(questions.getAnswer_by());
        return questionsRepository.saveAndFlush(existingQuestions);
    }

    public List<String> getNotAnswered( ){
        return questionsRepository.showNotAnswered();
    }


    public void deleteNotAnswered(Long id) {
        questionsRepository.deleteNotAnswered(id);
    }
    public List<Questions> findNotAnsweredByTopicId(Long id){
        return questionsRepository.findNotAnsweredByTopicId(id);
    }

}
