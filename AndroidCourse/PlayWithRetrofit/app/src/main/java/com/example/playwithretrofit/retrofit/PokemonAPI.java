package com.example.playwithretrofit.retrofit;

import com.example.playwithretrofit.model.Pokemon;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonAPI {

    @GET("pokemon/{id}")
    Call<Pokemon> getPokemonById(@Path("id") int id);
}
