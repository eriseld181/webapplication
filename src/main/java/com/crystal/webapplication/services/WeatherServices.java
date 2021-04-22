package com.crystal.webapplication.services;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.mappers.WeatherMapper;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class  WeatherServices <Weather> {
    @Autowired
    private WeatherRepository weatherRepository;

//    public WeatherDto get(String date){
//        Weather weather =  weatherRepository.findOne(date);
//        WeatherDto weatherDto = WeatherMapper.converttoDto(weather);
//        return weatherDto;
//    }
//    public List<WeatherDto> get_for_X(int nr_days){
//        List<Weather> weathers =  new ArrayList<>();
//                for(int i=1;i<=nr_days;i++)weathers.add(weatherRepository.findOne(i));
//        List<WeatherDto> weatherDtos= new ArrayList<>();
//        for(Weather wet: weathers){
//            weatherDtos.add(WeatherMapper.converttoDto(wet));
//        }
//        return weatherDtos;
//    }

}
