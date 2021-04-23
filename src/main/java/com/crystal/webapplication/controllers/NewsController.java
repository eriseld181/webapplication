package com.crystal.webapplication.controllers;

import java.util.List;
import java.util.Optional;

import com.crystal.webapplication.models.News;
import com.crystal.webapplication.repositories.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

	public NewsDto get(@PathVariable int id) {
		return newsService.getSome(id);
	}

	// funksjoni per te futur nje vlere, request body duhet ne te njejtin vend me
	// postmapping
	@PostMapping

	public ResponseEntity<News> createOne(@RequestBody final News news) {
		try {
			return ResponseEntity.ok()
					// .header("Custom-Header", "foo")
					.body(newsService.create(news));

		} catch (Exception ex) {
			
			return new ResponseEntity(
					"This news cannot be inserted into Database. Check 'title', 'description' or 'author'.",
					HttpStatus.BAD_REQUEST);
		}
	}

	// fshin nje element
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)

	public ResponseEntity delete(@PathVariable int id) {
		try {
			newsService.deleteOne(id);

			return new ResponseEntity("The user with selected " + id + " is deleted", HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity("The user with selected " + id + " is already deleted", HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public News update(@PathVariable int id, @RequestBody News news) {
		return newsService.updateOne(id, news);
	}

}
