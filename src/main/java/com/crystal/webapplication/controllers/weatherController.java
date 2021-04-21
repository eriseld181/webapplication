package com.crystal.webapplication.controllers;

import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/weathers")
public class weatherController {
    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping
    public List<Weather> list(){
        return weatherRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{idweather}")
    public Weather get(@PathVariable String idweather) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
        return weatherRepository.getOne(date);
    }
    @PostMapping
    public Weather create(@RequestBody final Weather weather){
        return weatherRepository.saveAndFlush(weather);
    }
    @RequestMapping(value = "{idweather}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String idweather) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
        weatherRepository.deleteById(date);
    }
    @RequestMapping(value = "{idweather}", method = RequestMethod.PUT)
    public Weather update(@PathVariable String idweather, @RequestBody Weather weather) throws ParseException {
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
        Weather existingWeather = weatherRepository.getOne(date);
        BeanUtils.copyProperties(weather,existingWeather,"idweather");
        return weatherRepository.saveAndFlush(existingWeather);
    }

}
