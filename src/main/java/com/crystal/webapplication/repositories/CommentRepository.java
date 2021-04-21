package com.crystal.webapplication.repositories;
//Create Comment Repository with the following list of functionalities

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crystal.webapplication.models.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer>{
	
	
	
	
	//Insert new comment
//	@Modifying
//	@Query(value="insert into comments (comment_text, author, news_id) values (:comment_text, :comment_author, :news_id)",nativeQuery = true)
//	public void insertComment(@Param("comment_text") String comment_text, @Param("comment_author") String comment_author, @Param("news_id") Integer news_id);
	
//	//Delete comment
//	//@Query
//	public void deleteCommentByIdandAuthor(Integer id, String author);
//	
//	//Approve comment by admin
//	//@Query
//	public void updateCommentByApproved_byAndApproved_date(String approved_by, Date approved_date);
//	
//	//Read all comments for a specific news
//	public List<Comment> findAllByNews_id(Integer news_id);
		
}
