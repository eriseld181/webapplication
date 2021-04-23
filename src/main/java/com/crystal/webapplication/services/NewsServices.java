package com.crystal.webapplication.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.crystal.webapplication.controllers.NewsController;

import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.mappers.NewsMapper;
import com.crystal.webapplication.models.News;
import com.crystal.webapplication.repositories.NewsRepository;

//tregon qe eshte per services
@Service

public class NewsServices {

	// krijon objektin
	@Autowired
	private NewsRepository newsRepository;
	//private NewsMapper newsMapper;

	public List<News> list() {
		return newsRepository.findAll();
	}

	public void deleteOne(int id) {

		newsRepository.deleteById(id);
	}
	//per te bere search
	public List<News> findByTitleFunction(String title){
		return newsRepository.findByTitle(title);
	}

	// funsjoni per per te krijuar nje news te ri
	public News create( News news) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		  
		news.setCreation_date(dtf.format(now));
		return newsRepository.saveAndFlush(news);
	}
	//funksjoni per te bere update nje specific news
	public News updateOne( int id,  News news) {
	 	News exisitingNews = newsRepository.getOne(id);
		BeanUtils.copyProperties(news, exisitingNews, "id");
	 	return newsRepository.saveAndFlush(exisitingNews);
		
	}
	public News getFirst( int id) {
		return newsRepository.getOne(id);
	}
	
	public NewsDto getSome(int id) {
		NewsMapper newsM = new NewsMapper();
		return newsM.modelMapper(newsRepository.getOne(id));
	}


}
