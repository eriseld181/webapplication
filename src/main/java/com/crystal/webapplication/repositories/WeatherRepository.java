package com.crystal.webapplication.repositories;


import com.crystal.webapplication.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface WeatherRepository extends JpaRepository<Weather, String> {
}
