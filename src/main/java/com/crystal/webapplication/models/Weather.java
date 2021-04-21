package com.crystal.webapplication.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="weather")
public class Weather {
      @Id
      //@GeneratedValue(strategy = GenerationType.SEQUENCE)
      private String idweather;
      private String weather_day_name;
      private String weather_description;
      private String temp_morning;
      private String temp_midday;
      private String temp_afternon;

    public String getIdWeather() {
        return idweather;
    }

    public void setIdWeather(String idweather) {
        /*Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
        String dateOnly = dateFormat.format(currentDate);
        //System.out.println(dateOnly);*/
        this.idweather = idweather;
    }

    public String getWeather_day_name() {
        return weather_day_name;
    }

    public void setWeather_day_name(String weather_day_name) {
        this.weather_day_name = weather_day_name;
    }

    public String getWeather_description() {
        return weather_description;
    }

    public void setWeather_description(String weather_description) {
        this.weather_description = weather_description;
    }

    public String getTemp_morning() {
        return temp_morning;
    }

    public void setTemp_morning(String temp_morning) {
        this.temp_morning = temp_morning;
    }

    public String getTemp_midday() {
        return temp_midday;
    }

    public void setTemp_midday(String temp_midday) {
        this.temp_midday = temp_midday;
    }

    public String getTemp_afternon() {
        return temp_afternon;
    }

    public void setTemp_afternon(String temp_afternon) {
        this.temp_afternon = temp_afternon;
    }
}
