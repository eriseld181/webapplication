package com.crystal.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crystal.webapplication.models.NewsModel;

public interface NewsRepository extends JpaRepository<NewsModel ,Long>{

}
