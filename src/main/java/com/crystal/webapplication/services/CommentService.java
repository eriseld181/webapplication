package com.crystal.webapplication.services;

import java.util.ArrayList;
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
	public Comment createAComment(int news_id, Comment comment) {
		News news= newsRepository.getOne(news_id);
		return commentRepository.saveAndFlush(comment);
	}
	
	
	//Delete all comments by id and author. Method defined in commentRepository interface
	@Transactional
	public void deleteCommentByIdAndAuthor(Integer id, String author) {
		commentRepository.deleteByIdAndAuthor(id, author);
	}
	
	//Update approved_by and approved_date in order to approve the comment
	public Comment updateToApprove(Integer id, Comment comment) {
		Comment existingComment= commentRepository.getOne(id);
		existingComment.setComment_approved_by(comment.getComment_approved_by());
		existingComment.setComment_approved_date(comment.getComment_approved_date());
		//BeanUtils.copyProperties(comment, existingComment, "id");
		//BeanUtils.copyProperties(comment, existingComment, "id", "news_id", "comment_text", "author", "comment_date");
		//BeanUtils.copyProperties(comment, existingComment, "id, news_id, comment_text, author, comment_date");
		return commentRepository.saveAndFlush(existingComment);
	}

}
