package com.example.canilroomviewmodel.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.canilroomviewmodel.database.DogConfig;
import com.example.canilroomviewmodel.model.Dog;
import com.example.projecttest.R;
import com.example.projecttest.databinding.ActivityMainBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    DogConfig dogConfig;

    Call<Dog> requestDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        dogConfig = new DogConfig();

        binding.buttonRequest.setOnClickListener(v -> {
            int id = Integer.parseInt(binding.editText.getText().toString());
            requestDog = dogConfig.getDogAPI().getDogById(id);
            requestDog.enqueue(new Callback<Dog>() {
                @Override
                public void onResponse(Call<Dog> call, Response<Dog> response) {
                    try {
                        if (response.isSuccessful()) {
                            Dog dog = response.body();
                            binding.textViewId.setText(String.valueOf(dog.getId()));
                            binding.textViewNome.setText(dog.getName());
                            binding.textViewAltura.setText(String.valueOf(dog.getHeight()));
                            binding.textViewPeso.setText(String.valueOf(dog.getWeight()));
                            //binding.imageViewDog.setImageResource(dog.getImage());

                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid ID", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Dog> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Falha ao encontrar o cachorro", Toast.LENGTH_SHORT).show();
                }
            });
        });


    }
}
