package com.crystal.webapplication.controllers;

import java.util.List;


import com.crystal.webapplication.models.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.dto.NewsDto;
//import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.models.News;

import com.crystal.webapplication.services.NewsServices;


//ben rest api
@RestController
//vendos url per metoden e pershtatshme
@RequestMapping("/api/news")
public class NewsController {
	
	@Autowired
	private NewsServices newsService;
	//private NewsDto newsDto;
	
	@GetMapping
	public List<News> myMethod() {
		return newsService.list();
	}
	

	@RequestMapping("{id}")
	public News getAllFields(@PathVariable Long id) {
		return newsService.getFirst(id);
	}
	@RequestMapping("/some/{id}")
	
	public NewsDto get(@PathVariable Long id) {
		return newsService.getSome(id);
	}
	//funksjoni per te futur nje vlere, request body duhet ne te njejtin vend me postmapping
	@PostMapping
	public News createOne(@RequestBody final News news) {
		return newsService.create(news);
	}
	
	//fshin nje element
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	
	public void delete(@PathVariable Long id) {
		
		newsService.deleteOne(id);
	}
	
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public News update(@PathVariable Long id, @RequestBody  News news) {
		return newsService.updateOne(id, news );
	}

	
}
