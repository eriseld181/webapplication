package com.crystal.webapplication.repositories;


import com.crystal.webapplication.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public interface WeatherRepository extends JpaRepository<Weather, LocalDate> {
    @Query("select w from weather w where w.idweather between current_date AND ?1")
    public List<Weather> getWeatherDetailsforxdates(LocalDate localDate);
}
