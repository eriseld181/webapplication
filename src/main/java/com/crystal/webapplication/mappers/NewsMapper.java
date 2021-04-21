package com.crystal.webapplication.mappers;

import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.crystal.webapplication.dto.NewsDto;
import com.crystal.webapplication.models.News;

@Mapper
public class NewsMapper {

	public NewsDto modelMapper(News news) {
		NewsDto newsDto = new NewsDto();
		newsDto.setTitle(news.getTitle());
		newsDto.setDescription(news.getDescription());

		return newsDto;

	}

}
