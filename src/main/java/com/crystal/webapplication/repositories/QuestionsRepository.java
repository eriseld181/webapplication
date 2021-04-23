package com.crystal.webapplication.repositories;
import com.crystal.webapplication.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


import javax.transaction.Transactional;
import java.util.List;

public interface QuestionsRepository  extends JpaRepository <Questions,  Long>{
   @Query( value="select u.question_name  from questions  u where u.answer is NULL")
   List<String> showNotAnswered();

 @Query( value="select u from questions as u where u.topic_id =?1 and u.answer is null")
    List <Questions> findNotAnsweredByTopicId(Long topic_id);
    @Transactional
    @Modifying
    @Query( value="delete from questions as u where u.id=?1 and u.answer is NULL ")
    void  deleteNotAnswered(Long id);

}
