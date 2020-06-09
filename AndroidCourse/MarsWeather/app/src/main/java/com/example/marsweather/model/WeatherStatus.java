package com.example.marsweather.model;

import com.google.gson.annotations.SerializedName;

public class WeatherStatus {



    private String season;
    private Air air;

    public WeatherStatus() {}

    public WeatherStatus(String season, Air air, float average, float minimum, float maximum) {
        this.season = season;
        Temperature temperature = new Temperature(average, minimum,maximum);
        this.air = new Air(temperature);

    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public Air getAir() {
        return air;
    }

    public void setAir(Air air) {
        this.air = air;
    }
}

