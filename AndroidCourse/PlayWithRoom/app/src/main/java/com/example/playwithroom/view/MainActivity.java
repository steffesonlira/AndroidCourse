package com.example.playwithroom.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.playwithroom.R;
import com.example.playwithroom.adapters.PlayKiddingAdapter;
import com.example.playwithroom.database.DatabaseConnection;
import com.example.playwithroom.database.PlayGameOperations;
import com.example.playwithroom.databinding.ActivityMainBinding;
import com.example.playwithroom.model.PlayKidding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    List<PlayKidding> gameList;
    //DatabaseConnection connection;
    PlayKiddingAdapter adapter;
    PlayGameOperations operations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        gameList = new ArrayList<>();
        operations = new PlayGameOperations(this);

        adapter = new PlayKiddingAdapter(gameList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

        binding.buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayKidding playKidding = new PlayKidding("Amarelinha", 15, "Pular amarelinha");
                operations.insertPlayKidding(playKidding);
            }
        });

        binding.buttonGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameList.clear();
               // gameList.addAll(connection.playKiddindDao().getAllGames());
                gameList.addAll(operations.getAllGames());
                binding.recyclerView.scrollToPosition(adapter.getItemCount() - 1);
                adapter.notifyDataSetChanged();
            }
        });

        binding.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameList.size() > 0) {
                    operations.deleteLastItem(gameList.get(gameList.size() - 1));
                    gameList.remove(gameList.size() - 1);

                }

            }
        });
    }


}
