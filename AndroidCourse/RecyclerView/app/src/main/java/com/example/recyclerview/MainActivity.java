package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    //criar string rapdaidamente, digitar psfs

    private List<String> stringList = new ArrayList<String>();

    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        recyclerView = findViewById(R.id.reciclerView);
//        recyclerAdapter = new RecyclerAdapter(stringList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(recyclerAdapter);
        populateList();

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        
    }

    private void populateList(){
        for(int i = 1; i <= 20; i++){
            stringList.add("Aluno " + i);
            //Log.d(MainActivity.class.getSimpleName(), stringList.get(i));
        }
        Log.d(TAG, stringList.toString());
    }
}
