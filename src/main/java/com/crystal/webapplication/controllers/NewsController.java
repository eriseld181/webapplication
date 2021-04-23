package com.crystal.webapplication.controllers;

import java.util.List;
import java.util.Optional;

import com.crystal.webapplication.mappers.Ex;
import com.crystal.webapplication.models.MyResourceNotFoundException;
import com.crystal.webapplication.models.News;
import com.crystal.webapplication.models.Problem;
import com.crystal.webapplication.repositories.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.dto.NewsDto;
//import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.models.News;

import com.crystal.webapplication.services.NewsServices;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;

//ben rest api
@RestController
//vendos url per metoden e pershtatshme
@RequestMapping("/api/news")
public class NewsController {

	@Autowired
	private NewsServices newsService;
	// private NewsDto newsDto;
	@Autowired
	private NewsRepository newsRepository;
	// private NewsDto newsDto;

	@GetMapping
	public List<News> myMethod() {
		return newsService.list();
	}

	@RequestMapping("/search")
	public List<News> findAll(@RequestParam String title) {
		return newsService.findByTitleFunction(title);
	}

	@RequestMapping("{id}")
	public News getAllFields(@PathVariable int id) {
		return newsService.getFirst(id);
	}

	@RequestMapping("/some/{id}")
	public Object get(int id) {
		//if(newsService.returngabim(id) instanceof NewsDto)
		//return newsService.getSome(id);
		//return
		return newsService.returngabim(id);
	}

	// funksjoni per te futur nje vlere, request body duhet ne te njejtin vend me
	// postmapping
	@PostMapping
	public News createOne(@RequestBody final News news, HttpServletResponse response){

			return newsService.create(news);
	}

	// fshin nje element
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)

	public String delete(@PathVariable int id) {
		newsService.deleteOne(id);
		return "The user with selected " + id + " is deleted";

	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public News update(@PathVariable int id, @RequestBody News news) {
		return newsService.updateOne(id, news);
	}

}
