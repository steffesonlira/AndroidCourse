package com.example.marsweather.model;

import com.example.marsweather.retrofit.RetrofitConfig;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface MarsWeatherAPI {

    @GET("wheater/latest")
    Observable<WheaterStatus>getLatestWeaher();
}
