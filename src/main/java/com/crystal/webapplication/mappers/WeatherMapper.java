package com.crystal.webapplication.mappers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.models.Weather;
import org.springframework.stereotype.Service;


public class WeatherMapper {
        public static WeatherDto converttoDto(Weather weather){


            WeatherDto weatherDto = new WeatherDto();
            weatherDto.setT_mid(weather.getTemp_midday());
            weatherDto.setT_after(weather.getTemp_afternon());
            weatherDto.setT_morn(weather.getTemp_morning());
            weatherDto.setAvg(avg(weather));
            weatherDto.setDate(weather.getIdweather());
            weatherDto.setMax(max(weather));
            weatherDto.setMin(min(weather));
            return weatherDto;
        }
        public WeatherDto converttoDto2(Weather weather){
            WeatherDto weatherDto = new WeatherDto();
            weatherDto.setDate(weather.getIdweather());
            weatherDto.setMin(min(weather));
            weatherDto.setMax(max(weather));
            return weatherDto;
        }
        private double max(Weather weather){
            double max = weather.getTemp_morning();
            if(weather.getTemp_midday()>max) max = weather.getTemp_midday();
            if(weather.getTemp_afternon()>max) max = weather.getTemp_afternon();
            return max;
        }
        private double min(Weather weather){
            double min = weather.getTemp_morning();
            if(weather.getTemp_midday()>min) min = weather.getTemp_midday();
            if(weather.getTemp_afternon()>min) min = weather.getTemp_afternon();
            return min;
        }
        private double avg(Weather weather){
            double sum = 0;
            sum = weather.getTemp_morning()+weather.getTemp_midday()+ weather.getTemp_afternon();
            return sum/3;
        }

}
