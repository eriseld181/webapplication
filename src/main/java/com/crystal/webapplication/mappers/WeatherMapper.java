package com.crystal.webapplication.mappers;

import com.crystal.webapplication.dto.WeatherDto;
import com.crystal.webapplication.dto.WeatherDto2;
import com.crystal.webapplication.models.Weather;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class WeatherMapper {
    public static WeatherDto converttoDto(Weather weather) {


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

    public static WeatherDto converttoDto2(Weather weather) {
        WeatherDto weatherDto = new WeatherDto();
        weatherDto.setDate(weather.getIdweather());
        weatherDto.setMin(min(weather));
        weatherDto.setMax(max(weather));
        return weatherDto;
    }

    public static List<WeatherDto2> converttoDto1(List<Weather> weather) {
        List<WeatherDto2> weatherDto2 = new ArrayList<>();
        for(Weather w : weather) {
            WeatherDto2 weatherDto21 = new WeatherDto2();
            weatherDto21.setDate(w.getIdweather());
            weatherDto21.setMin(min(w));
            weatherDto21.setMax(max(w));
            weatherDto2.add(weatherDto21);
        }
        return weatherDto2;
    }
    public static WeatherDto2 converttoDto1(Weather weather) {
            WeatherDto2 weatherDto21 = new WeatherDto2();
            weatherDto21.setDate(weather.getIdweather());
            weatherDto21.setMin(min(weather));
            weatherDto21.setMax(max(weather));

        return weatherDto21;
    }

    private static double max(Weather weather) {
        double max = weather.getTemp_morning();
        if (weather.getTemp_midday() > max) max = weather.getTemp_midday();
        if (weather.getTemp_afternon() > max) max = weather.getTemp_afternon();
        return max;
    }

    private static double min(Weather weather) {
        double min = weather.getTemp_morning();
        if (weather.getTemp_midday() > min) min = weather.getTemp_midday();
        if (weather.getTemp_afternon() > min) min = weather.getTemp_afternon();
        return min;
    }

    private static double avg(Weather weather) {
        double sum = 0;
        sum = weather.getTemp_morning() + weather.getTemp_midday() + weather.getTemp_afternon();
        return sum / 3;
    }

}
