package com.crystal.webapplication.controllers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.crystal.webapplication.mappers.WeatherMapper;

import java.time.LocalDate;
import java.util.Date;
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
        return weatherServices.getWeatherDetailsDto(localDate);
    }
    //return one record with specified id-> date
    @GetMapping
    @RequestMapping("/one/{idweather}")
    public Weather Weather(@PathVariable String idweather){
        LocalDate localDate = LocalDate.parse(idweather);
        return weatherServices.getWeatherDetails(localDate);
    }
    //search x number of days
    @GetMapping
    @RequestMapping("/number/{numberofdays}")
    public List<WeatherDto> WeatherDtos(@PathVariable int numberofdays){
        return weatherServices.getWeatherDetailsforxdays(numberofdays);
    }
    @RequestMapping(value = "{idweather}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String idweather){
        LocalDate localDate = LocalDate.parse(idweather);
        weatherServices.deleteByDate(localDate);
    }
    @PostMapping("/insert")
    public WeatherDto create(@RequestBody final Weather weather){
        return WeatherMapper.converttoDto(weatherServices.insert(weather));
    }
}
