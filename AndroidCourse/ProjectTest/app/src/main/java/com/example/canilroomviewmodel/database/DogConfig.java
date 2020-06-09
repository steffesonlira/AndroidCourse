package com.example.canilroomviewmodel.database;

import com.example.canilroomviewmodel.model.Dog;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class DogConfig {

    private final Retrofit config;
    private String baseUrl = "https://api.thedogapi.com/v1/";

    public DogConfig() {

        config = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();

    }

    public DogAPI getDogAPI(){
        return config.create(DogAPI.class);
    }
}
