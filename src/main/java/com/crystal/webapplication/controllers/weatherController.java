package com.crystal.webapplication.controllers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crystal.webapplication.mappers.WeatherMapper;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weathers")
public class weatherController {
    @Autowired
    WeatherServices weatherServices;
    //return weather details for a specific day
    @GetMapping
    @RequestMapping("/n/{idweather}")
    public WeatherDto WeatherDto(@PathVariable String idweather){
        LocalDate localDate = LocalDate.parse(idweather);
        return weatherServices.getWeatherDetails(localDate);
    }
    //search x number of days
    @GetMapping
    @RequestMapping("/number/{numberofdays}")
    public List<WeatherDto> WeatherDtos(@PathVariable int numberofdays){
        return weatherServices.getWeatherDetailsforxdays(numberofdays);
    }
}
