package com.example.canilroomviewmodel.database;

import com.example.canilroomviewmodel.model.Dog;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;


public interface DogAPI {

    @GET("breeds/{id}")
    Call<Dog> getDogById(@Path("id") int id);


}
