package com.crystal.webapplication.dto;

import java.time.LocalDate;
import java.util.Date;

public class WeatherDto {
    private LocalDate idweather;
    private double t_morn;
    private double t_mid;
    private double t_after;
    private double max;
    private double min;
    private double avg;


    public LocalDate getDate() {
        return idweather;
    }

    public void setDate(LocalDate date) {
        this.idweather = date;
    }

    public double getT_morn() {
        return t_morn;
    }

    public void setT_morn(double t_morn) {
        this.t_morn = t_morn;
    }

    public double getT_mid() {
        return t_mid;
    }

    public void setT_mid(double t_mid) {
        this.t_mid = t_mid;
    }

    public double getT_after() {
        return t_after;
    }

    public void setT_after(double t_after) {
        this.t_after = t_after;
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
