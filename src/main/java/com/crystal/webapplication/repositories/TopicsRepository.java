package com.crystal.webapplication.repositories;
import com.crystal.webapplication.models.Questions;
import com.crystal.webapplication.models.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TopicsRepository  extends JpaRepository <Topics,Long>{
}
