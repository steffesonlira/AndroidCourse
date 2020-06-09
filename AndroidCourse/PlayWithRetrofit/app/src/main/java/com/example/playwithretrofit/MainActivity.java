package com.example.playwithretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.playwithretrofit.databinding.ActivityMainBinding;
import com.example.playwithretrofit.model.Pokemon;
import com.example.playwithretrofit.retrofit.RetrofitConfig;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    RetrofitConfig retrofitConfig;

    Call<Pokemon> request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        retrofitConfig = new RetrofitConfig();

        binding.buttonRequest.setOnClickListener(v -> {
            int id = Integer.parseInt(binding.editTextSearch.getText().toString());
            request = retrofitConfig.getPokemonAPI().getPokemonById(id);
            request.enqueue(new Callback<Pokemon>() {
                @Override
                public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                    try {
                        if (response.isSuccessful()) {
                            Pokemon pokemon = response.body();
                            binding.textViewId.setText(String.valueOf(pokemon.getId()));
                            binding.textViewName.setText(pokemon.getName());
                            binding.textViewAltura.setText(String.valueOf(pokemon.getHeight()));
                            binding.textViewPeso.setText(String.valueOf(pokemon.getWeight()));
                        }else{
                            Toast.makeText(getApplicationContext(), "Invalid ID", Toast.LENGTH_SHORT).show();

                        }

                    }catch (Exception e){
                        Toast.makeText(getApplicationContext(), e.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }

                @Override
                public void onFailure(Call<Pokemon> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), "Fail to get Pokemon", Toast.LENGTH_SHORT).show();

                }
            });
        });


    }
}
