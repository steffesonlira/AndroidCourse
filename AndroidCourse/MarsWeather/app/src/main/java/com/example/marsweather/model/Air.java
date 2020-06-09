package com.example.marsweather.model;

public class Air {
    private Temperature temperature;

    public Air(Temperature temperature) {
        this.temperature = temperature;
    }
    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

}
