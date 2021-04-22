package com.crystal.webapplication.repositories;
//Create Comment Repository with the following list of functionalities

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystal.webapplication.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	//Read all comments for a specific news
	public List<Comment> findAllByNewsId(Integer news_id);
	
	//Delete comment
	public void deleteByIdAndAuthor(Integer id, String author);
	
//	@Query("DELETE FROM comments c WHERE c.id= :id and c.author= :author")
//	public void deleteByIdAndAuthor(@Param("id") Integer id,@Param("author") String author);
	
	//Approve comment by admin
//	@Query("UPDATE comments SET approved_by= :approved_by AND approved_date= :approved_date WHERE id=:id")
//	public Comment update(@Param("id") Integer id, @Param("approved_by") String approved_by,@Param("approved_date") Date approved_date) ;
	
		
}
