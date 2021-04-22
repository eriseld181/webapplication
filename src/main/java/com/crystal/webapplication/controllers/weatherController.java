package com.crystal.webapplication.controllers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.mappers.WeatherMapper;
import com.crystal.webapplication.models.Weather;
import com.crystal.webapplication.repositories.WeatherRepository;
import com.crystal.webapplication.services.WeatherServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/weathers")
public class weatherController {
//    @Autowired
//    private WeatherServices weatherServices;
    @Autowired
    private WeatherRepository weatherRepository;
    private List<Weather> full = new ArrayList<>();

//    @GetMapping
//    public List<Weather> list(){
//        return weatherRepository.findAll();
//    }
//    @GetMapping
//    @RequestMapping("{idweather}")
//    public Weather get(@PathVariable String idweather) throws ParseException {
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
//        return weatherRepository.getOne(date);
//    }
//    @PostMapping
//    public Weather create(@RequestBody final Weather weather){
//        return weatherServices.saveAndFlush(weather);
//    }

    //Return one record for day specified
    @GetMapping
    @RequestMapping("/findone/{idweather}")
    public WeatherDto get(@PathVariable String idweather){
        get();
        WeatherDto dto_vetem = new WeatherDto();
        for(Weather weth : full){
            if(weth.getIdweather().startsWith(idweather)) {
                dto_vetem = WeatherMapper.converttoDto(weth);
            }
        }
        return dto_vetem;
    }
    @GetMapping
    @RequestMapping("/findall")
    public List<WeatherDto> getAll(){
        get();
        List<WeatherDto> w = new ArrayList<>();
        for(Weather j : full){
            w.add(WeatherMapper.converttoDto(j));
        }
        return w;
    }
    @GetMapping
    @RequestMapping("/findspecific/{nr_days}")
    public List<WeatherDto> getall(@PathVariable int nr_days){
        get();
        List<WeatherDto> liste_dto = new ArrayList<>();
        for(Weather weth : full){
            if(liste_dto.size()<nr_days){
                liste_dto.add(WeatherMapper.converttoDto2(weth));
            }
        }
        return liste_dto;
    }
    @RequestMapping(value = "/delete/{idweather}" ,method = RequestMethod.DELETE)
    public void delete(@PathVariable String idweather){
        weatherRepository.deleteById(idweather);
    }
    @PostMapping("/insert")
    public Weather create(@RequestBody final Weather weather){
        get();
        getall(10);
        return weatherRepository.saveAndFlush(weather);
    }
    public void get(){
        full= weatherRepository.findAll();
    }

//    @RequestMapping(value = "{idweather}",method = RequestMethod.DELETE)
//    public void delete(@PathVariable String idweather) throws ParseException {
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
//        weatherRepository.deleteById(date);
//    }
//    @RequestMapping(value = "{idweather}", method = RequestMethod.PUT)
//    public Weather update(@PathVariable String idweather, @RequestBody Weather weather) throws ParseException {
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(idweather);
//        Weather existingWeather = weatherRepository.getOne(date);
//        BeanUtils.copyProperties(weather,existingWeather,"idweather");
//        return weatherRepository.saveAndFlush(existingWeather);
//    }

}
