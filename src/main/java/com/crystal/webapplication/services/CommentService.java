package com.crystal.webapplication.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.crystal.webapplication.dto.CommentDto;
import com.crystal.webapplication.mappers.CommentMapper;
import com.crystal.webapplication.models.Comment;
import com.crystal.webapplication.models.News;
import com.crystal.webapplication.repositories.CommentRepository;
import com.crystal.webapplication.repositories.NewsRepository;

@Service
public class CommentService {
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	//List all comments
	public List<Comment> list(){
		return commentRepository.findAll();
	}
	
	//List all comments for a specific news
	public List<CommentDto> listAllCommentsOfANews(Integer news_id){
		List<Comment> comments= commentRepository.findAllByNewsId(news_id);
		List<CommentDto> commentsDto= new ArrayList<>();
		for (Comment comment : comments) {
			CommentDto dto= CommentMapper.mappCommentToDto(comment);
			commentsDto.add(dto);
		}
		return commentsDto;
	}
	
	//Create a comment
	public boolean createAComment(int news_id, Comment comment) {
		//check if comment is not null
		if(comment != null) {
			//if the comment or author is null then return false
			if(comment.getComment_author()==null || comment.getComment_text()==null) {
				return false;
			}	
		}
		//if everything is ok
		Date date= new Date();
		comment.setComment_date(date);
		News news= newsRepository.getOne(news_id);
		comment.setNews(news);	
		commentRepository.saveAndFlush(comment);
		return true;
	}
	
	
	//Delete all comments by id and author. Method defined in commentRepository interface
	@Transactional
	public void deleteCommentByIdAndAuthor(Integer id, String author) {
		commentRepository.deleteByIdAndAuthor(id, author);
	} 
	
	//Update approved_by and approved_date in order to approve the comment
	public boolean updateToApprove(Integer id, Comment comment) {
		//check if comment is not null
		if(comment != null) {
			//if the attribute approved_by or approved_date is null then return false
			if(comment.getComment_approved_by()==null || comment.getComment_approved_date()==null) {
				Comment newComment= new Comment();
				return false;
			}
		}
		//if everything is ok
		Comment existingComment= commentRepository.getOne(id);
		existingComment.setComment_approved_by(comment.getComment_approved_by());
		existingComment.setComment_approved_date(comment.getComment_approved_date());
		commentRepository.saveAndFlush(existingComment);
		return true;
	}

}
