package com.crystal.webapplication.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
import com.crystal.webapplication.repositories.CommentRepository;
import com.crystal.webapplication.repositories.NewsRepository;
import com.crystal.webapplication.services.CommentService;

@RestController
@RequestMapping("/comment") //the url: localhost:8080/comment
public class CommentController {
	@Autowired
 	private CommentService commentService;
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private NewsRepository newsRepository;
	
	//LIST ALL COMMENTS
	@GetMapping
	public ResponseEntity<List<Comment>> getAll(){
		if(commentRepository.findAll().size()!=0) {
			return ResponseEntity.status(HttpStatus.OK).body(commentService.list());
		}
		else {
			List<Comment> commentList= new ArrayList<>();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(commentList);
		}
	}
	
	//LIST ALL COMMENTS FOR A NEWS
	@GetMapping("/api/{news_id}") 
	public ResponseEntity<List<CommentDto>> getAllCommentsOfANews(@PathVariable (value="news_id") Integer news_id){
		if(newsRepository.existsById(news_id)) {
			return ResponseEntity.status(HttpStatus.OK).body(commentService.listAllCommentsOfANews(news_id));
		}
		else {
			List<CommentDto> commentListDto= new ArrayList<>();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(commentListDto);
		}
	}
	
	//DELETE A COMMENT
	@DeleteMapping("{id}/{author}")
	public ResponseEntity<String> delete(@PathVariable (value= "id") Integer id, @PathVariable (value= "author") String author) {
		if(commentRepository.existsByIdAndAuthor(id, author)) {
			commentService.deleteCommentByIdAndAuthor(id, author);
			return ResponseEntity.status(HttpStatus.OK).body("Deleted successfully");	
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while deleting");	
	}
	
	//CREATE A COMMENT
	@PostMapping("{news_id}") 
	public ResponseEntity<String> create(@PathVariable (value="news_id") Integer news_id, @RequestBody final Comment comment) {
		if(newsRepository.existsById(news_id)) {
			if(commentService.createAComment(news_id, comment)) {
				return ResponseEntity.status(HttpStatus.OK).body("Comment created");
			}
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while inserting");
		}
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This news does not exist!");
	}	
	
	//UPDATE-APPROVE A COMMENT
	@RequestMapping(value="{id}", method= RequestMethod.PUT)
	public ResponseEntity<String> approve(@PathVariable(value= "id") Integer id, @RequestBody Comment comment) {		
		if(commentRepository.existsById(id)) {
			if(commentService.updateToApprove(id, comment)) {
				return ResponseEntity.status(HttpStatus.OK).body("Comment updated");
			}
			else 
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while updating");	
		}
		else 
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("This comment does not exist!");	
	}
	
	
}
