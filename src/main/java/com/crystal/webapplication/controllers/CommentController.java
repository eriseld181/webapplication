package com.crystal.webapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.models.Comment;
import com.crystal.webapplication.repositories.CommentRepository;
import com.crystal.webapplication.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {
	@Autowired
 	private CommentRepository commentRepository;
	
	@GetMapping
	public List<Comment> list(){
		return commentRepository.findAll();
	}
	
	@PostMapping
	public Comment create(@RequestBody final Comment comment) {
		return commentRepository.saveAndFlush(comment);		   
	}	
	
}
