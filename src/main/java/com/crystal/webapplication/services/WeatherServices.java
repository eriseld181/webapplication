package com.crystal.webapplication.services;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.dto.WeatherDto2;
import com.crystal.webapplication.mappers.WeatherMapper;
import com.crystal.webapplication.models.Problem;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class  WeatherServices {
    @Autowired
    private WeatherRepository weatherRepository;

    public WeatherDto getWeatherDetailsDto(LocalDate localDate){
        //Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Optional<Weather> weather =  weatherRepository.findById(localDate);
        WeatherDto weatherDto =  new WeatherDto();
        if(weather.isPresent()) weatherDto = WeatherMapper.converttoDto(weather.get());
        return weatherDto;
    }
    //return object weather not Dto
     public Weather getWeatherDetails(LocalDate localDate){
        //Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Optional<Weather> weather =  weatherRepository.findById(localDate);
        Weather weathe =  new Weather();
        if(weather.isPresent()) weathe = weather.get();
        return weathe;
    }

    public List<WeatherDto2> getWeatherDetailsforxdays(int nr) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(nr);
        List<Weather> weathers =  weatherRepository.getWeatherDetailsforxdates(localDate);
        List<WeatherDto2> weatherDtos = WeatherMapper.converttoDto1(weathers);
        return weatherDtos;
    }
    public void deleteByDate(LocalDate localDate){
        weatherRepository.deleteById(localDate);
    }
    public Object insert(Weather weather) {
        Problem problem = new Problem();
        problem.setProbName("Check weather details : weather ,weather temps etc");
        if(weather !=null && weather.getIdweather()!=null){
            return ResponseEntity.status(HttpStatus.OK).body(weatherRepository.saveAndFlush(weather));
        }
       else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Check weaather deatils date , temps etc");
        }
    }
}
