package com.crystal.webapplication.services;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.dto.WeatherDto2;
import com.crystal.webapplication.exceptions.MyEx;
import com.crystal.webapplication.mappers.WeatherMapper;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
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

    public Weather insert(Weather weather) {
        Weather weather1 =  weatherRepository.saveAndFlush(weather);
        return weather1;

    }



//    public static boolean isValid(final String date) {
//
//        boolean valid = false;
//
//        try {
//
//            // ResolverStyle.STRICT for 30, 31 days checking, and also leap year.
//            LocalDate.parse(date,
//                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
//                            .withResolverStyle(ResolverStyle.STRICT)
//            );
//
//            valid = true;
//
//        } catch (DateTimeParseException e) {
//            e.printStackTrace();
//            valid = false;
//        }
//
//        return valid;
//    }
}
