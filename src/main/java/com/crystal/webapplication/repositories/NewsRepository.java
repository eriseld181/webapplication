package com.crystal.webapplication.repositories;

import java.util.List;

import com.crystal.webapplication.models.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.crystal.webapplication.models.News;

public interface NewsRepository extends JpaRepository<News, Integer> {
	@Query("select n from news n where title like %?1%")
 List<News> findByTitle(String title);
	//Object returngabim();

	
}
