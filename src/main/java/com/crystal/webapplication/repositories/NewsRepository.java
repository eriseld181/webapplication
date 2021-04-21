package com.crystal.webapplication.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crystal.webapplication.models.News;

public interface NewsRepository extends JpaRepository<News ,Long>{

}
