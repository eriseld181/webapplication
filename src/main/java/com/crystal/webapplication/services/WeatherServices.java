package com.crystal.webapplication.services;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class WeatherServices {
    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherDto get(@PathVariable String date){
        Weather weather = weatherRepository.findById(date);
    }

}
