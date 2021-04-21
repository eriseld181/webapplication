package com.crystal.webapplication.controllers;

import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/weathers")
public class weatherController {
    @Autowired
    private weatherRepository weatherRepository;

    @GetMapping
    public List<Weather> list(){
        return weatherRepository.findAll();
    }
    @GetMapping
    @RequestMapping("{idweather}")
    public Weather get(@PathVariable String idweather){
        return weatherRepository.getOne(idweather);
    }
    @PostMapping
    public Weather create(@RequestBody final Weather weather){
        return weatherRepository.saveAndFlush(weather);
    }
    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable String id){
        weatherRepository.deleteById(id);
    }
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Weather update(@PathVariable String id, @RequestBody Weather weather){
        Weather existingWeather = weatherRepository.getOne(id);
        BeanUtils.copyProperties(weather,existingWeather,"idweather");
        return weatherRepository.saveAndFlush(existingWeather);
    }

}
