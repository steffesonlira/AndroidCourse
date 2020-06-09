package com.example.marsweather.model;

import com.google.gson.annotations.SerializedName;

public class WheaterStatus {

    private String season;
    private Air air;


    public WheaterStatus(String season, Air air) {
        this.season = season;
        this.air = air;

    }

    public WheaterStatus(String season, float average, float maximum, float minimum) {
        this.season = season;
        Temperature temperature = new Temperature(average, maximum, minimum);
        this.air = getAir();
    }

    public WheaterStatus(){

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
public class Air{


    private Temperature temperature;

    public Air(Temperature temperature){
        this.temperature = temperature;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }
}

class Temperature{
    @SerializedName("average")
    private float average;
    private float minimum;
    private float maximum;
}
