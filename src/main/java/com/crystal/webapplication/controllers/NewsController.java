package com.crystal.webapplication.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.models.News;
<<<<<<< HEAD

=======
import com.crystal.webapplication.repositories.NewsRepository;
>>>>>>> 3fbf4ace84dfa390c2159429490d383444f8f15e
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
