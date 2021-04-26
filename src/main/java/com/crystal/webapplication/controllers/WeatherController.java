package com.crystal.webapplication.controllers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.dto.WeatherDto2;
import com.crystal.webapplication.mappers.Ex;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import com.crystal.webapplication.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.crystal.webapplication.mappers.WeatherMapper;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/weathers")
public class WeatherController {
    @Autowired
    WeatherServices weatherServices;
    //return weather details for a specific day
    @GetMapping
    @RequestMapping("/n/{idweather}")
    public ResponseEntity WeatherDto(@PathVariable String idweather){

        LocalDate localDate = LocalDate.parse(idweather);
        if(weatherServices.getWeatherDetailsDto(localDate).getDate()==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("The date requested  " + idweather + " not found !");
        }
        else {
            //WeatherDto weatherDto = new WeatherDto();
            return ResponseEntity.status(HttpStatus.OK).body(weatherServices.getWeatherDetailsDto(localDate));
        }
    }
    //return one record with specified id-> date
    @GetMapping
    @RequestMapping("/one/{idweather}")
    public ResponseEntity Weather(@PathVariable String idweather){
        LocalDate localDate = LocalDate.parse(idweather);
        if(weatherServices.getWeatherDetails(localDate).getIdweather()==null){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("The date requested  " + idweather + " not found !");
        }
        else {
            //WeatherDto weatherDto = new WeatherDto();
            return ResponseEntity.status(HttpStatus.OK).body(weatherServices.getWeatherDetails(localDate));
        }
    }
    //search x number of days
    @GetMapping
    @RequestMapping("/number/{numberofdays}")
    public ResponseEntity <List<WeatherDto2>> WeatherDtos(@PathVariable int numberofdays){
        if(weatherServices.getWeatherDetailsforxdays(numberofdays).size()==0){
            return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(weatherServices.getWeatherDetailsforxdays(numberofdays));
        }else {
            return ResponseEntity.status(HttpStatus.OK).body(weatherServices.getWeatherDetailsforxdays((numberofdays)));
        }
    }
    @RequestMapping(value = "{idweather}",method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable String idweather){
        LocalDate localDate = LocalDate.parse(idweather);
        try{
            weatherServices.deleteByDate(localDate);
            return   ResponseEntity.status(HttpStatus.OK).body("Date with id "+idweather+ " deleted successfully");
        }catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(idweather+ " not found or is deleted");
        }
    }
    @PostMapping("/insert")
    public Object create(@RequestBody final Weather weather){
            return weatherServices.insert(weather);
    }
}
