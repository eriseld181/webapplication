package com.crystal.webapplication.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;

import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.models.NewsModel;

public class NewsModelMapper {
	@Bean
	public NewsDto modelMapper(NewsModel newsModel) {
		NewsDto a = new NewsDto();
		
		 a.setTitle(newsModel.getTitle());
		 a.setDescription(newsModel.getDescription());
		System.out.println(a.getDescription());
		return a;
	}
	
	
}
