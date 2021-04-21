package com.crystal.webapplication.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crystal.webapplication.models.Comment;
import com.crystal.webapplication.repositories.CommentRepository;

@Service
public class CommentService {
	
//	@Autowired
// 	private CommentRepository commentRepository;
//	
//	@GetMapping
//	public List<Comment> list(){
//		return commentRepository.findAll();
//	}
//	
//	@GetMapping
//	@RequestMapping("{news_id}")
//	public List<Comment> findAllByNews_id(@RequestBody Integer news_id){
//		return commentRepository.findAllByNews_id(news_id);
//	}
//	
//	@PostMapping
//	public Comment create(@RequestBody final Comment comment) {											   
//		return commentRepository.saveAndFlush(comment);		   
//	}	
//	
//	@RequestMapping(value = "{id}/{author}", method = RequestMethod.DELETE)
//	public void delete(@PathVariable Integer id, @PathVariable String author) {
//		// Also need to check for children record before deleting.... TO DO
//		commentRepository.deleteCommentByIdandAuthor(id, author);
//	}
//	
//	@RequestMapping(value="{id}", method= RequestMethod.PUT)
//	public Comment update(@PathVariable Integer id, @RequestBody String approved_by, @RequestBody Date approved_date) {
//		
//		Comment existingComment= commentRepository.getOne(id); 
//		return commentRepository.saveAndFlush(existingComment);
//	}
}
