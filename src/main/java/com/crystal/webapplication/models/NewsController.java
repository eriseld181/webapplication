package com.crystal.webapplication.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crystal.webapplication.repositories.NewsRepository;

public class NewsController {
	String a = "":hello";
	@Autowired
	private NewsRepository newsrepository;
	
	@GetMapping
	@RequestMapping(value="{id}", method =RequestMethod.DELETE)
	
	public void deleteOne(@PathVariable Long id) {
		
		newsrepository.deleteById(id);
	}
}
