package com.example.marsweather.retrofit;

import com.example.marsweather.model.MarsPhoto;

import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitConfig {

    private final Retrofit retrofit;
    private String baseURL = "https://api.mars.spacexcompanion.app/v1/";
    private String photoBaseUrl = "http://mars-photos.herokuapp.com/api/v1/";

    public RetrofitConfig(boolean isPhoto) {
        retrofit = new Retrofit.Builder()
                .baseUrl(isPhoto ? photoBaseUrl : baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();
    }

    public RetrofitConfig(Retrofit retrofit){
        this.retrofit = retrofit;
        new RetrofitConfig(false);
    }

    public MarsWeatherAPI getMarsWeatherAPI(){
        return retrofit.create(MarsWeatherAPI.class);
    }

    public MarsPhotoAPI getMarsPhotoAPI(){
        return retrofit.create(MarsPhotoAPI.class);
    }
}
