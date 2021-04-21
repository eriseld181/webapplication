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
      private double temp_morning;
      private double temp_midday;
      private double temp_afternon;

      public Weather(){}

    public String getIdweather() {
        return idweather;
    }

    public void setIdweather(String idweather) {
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

    public double getTemp_morning() {
        return temp_morning;
    }

    public void setTemp_morning(double temp_morning) {
        this.temp_morning = temp_morning;
    }

    public double getTemp_midday() {
        return temp_midday;
    }

    public void setTemp_midday(double temp_midday) {
        this.temp_midday = temp_midday;
    }

    public double getTemp_afternon() {
        return temp_afternon;
    }

    public void setTemp_afternon(double temp_afternon) {
        this.temp_afternon = temp_afternon;
    }
}
