package com.crystal.webapplication.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.models.News;

import com.crystal.webapplication.services.NewsServices;

//ben rest api
@RestController
//vendos url per metoden e pershtatshme
@RequestMapping("/api/news")
public class NewsController {
	
	@Autowired
	private NewsServices newsService;
	@GetMapping
	public List<News> myMethod() {
		return newsService.list();
	}
	
	
	
	
//	@GetMapping
//	@RequestMapping(value="{id}", method =RequestMethod.DELETE)
//	
//	public void deleteOne(@PathVariable Long id) {
//		
//		newsrepository.deleteById(id);
//	}
}
