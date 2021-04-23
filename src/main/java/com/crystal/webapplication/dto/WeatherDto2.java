package com.crystal.webapplication.dto;

import java.time.LocalDate;
import java.util.Date;

public class WeatherDto2 {
    private LocalDate idweather;
    private double max;
    private double min;
    private double avg;


    public LocalDate getDate() {
        return idweather;
    }

    public void setDate(LocalDate date) {
        this.idweather = date;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }
}
