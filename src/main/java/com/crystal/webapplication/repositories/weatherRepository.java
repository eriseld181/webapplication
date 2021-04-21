package com.crystal.webapplication.repositories;

import com.crystal.webapplication.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface weatherRepository extends JpaRepository<Weather,String> {
}
