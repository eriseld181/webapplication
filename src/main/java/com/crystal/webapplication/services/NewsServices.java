package com.crystal.webapplication.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.mappers.NewsModelMapper;
import com.crystal.webapplication.models.NewsController;
import com.crystal.webapplication.models.NewsModel;
import com.crystal.webapplication.repositories.NewsRepository;



@Service

public class NewsServices {
	@Autowired
	private NewsRepository newsRepository;
	
	public List<NewsModel> list(){
		return newsRepository.findAll();
	}
	//@GetMapping
	//NewsController.deleteOne();
	
	
}
