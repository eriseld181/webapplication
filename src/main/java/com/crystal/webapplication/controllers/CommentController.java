package com.crystal.webapplication.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.crystal.webapplication.dto.CommentDto;
import com.crystal.webapplication.models.Comment;
import com.crystal.webapplication.services.CommentService;

@RestController
@RequestMapping("/comment") //the url: localhost:8080/comment
public class CommentController {
	@Autowired
 	private CommentService commentService;
	
	@GetMapping
	public List<Comment> getAll(){
		return commentService.list();
	}
	
	@GetMapping
	@RequestMapping("/api/{news_id}") 
	public List<CommentDto> getAllCommentsOfANews(@PathVariable (value="news_id") Integer news_id){
		return commentService.listAllCommentsOfANews(news_id);
	}
	
	@GetMapping
	@RequestMapping(value = "{id}/{author}", method = RequestMethod.DELETE)
	public void delete(@PathVariable (value= "id") Integer id, @PathVariable (value= "author") String author) {
		commentService.deleteCommentByIdAndAuthor(id, author);
	}
	
	@PostMapping
	@RequestMapping("{news_id}") 
	public Comment create(@PathVariable (value="news_id") Integer news_id, @RequestBody final Comment comment) {
		return commentService.createAComment(news_id, comment);

	}	
	
	//@RequestMapping(value="{id}", method= RequestMethod.PATCH)
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public Comment approve(@PathVariable(value= "id") Integer id, @RequestBody Comment comment) {		
		return commentService.updateToApprove(id, comment);
	}
	
	
}
