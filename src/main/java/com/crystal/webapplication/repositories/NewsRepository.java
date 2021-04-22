package com.crystal.webapplication.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crystal.webapplication.models.News;

public interface NewsRepository extends JpaRepository<News, Long> {
	public static List<News> searchNews(String search) {

		return null;

	}
}
