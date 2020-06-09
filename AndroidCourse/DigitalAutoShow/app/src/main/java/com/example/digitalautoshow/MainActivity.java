package com.example.digitalautoshow;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateCarList();

        CarListAdapter adapter = new CarListAdapter(carList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    private void populateCarList(){

        Car car1 = new Car(0,"Raro", "500",2018,R.drawable.car1);
        Car car2 = new Car(1,"Chevelle", "450",1988,R.drawable.chevelle);
        Car car3 = new Car(2,"Civic", "120",2005,R.drawable.civic);
        Car car4 = new Car(3,"Fusca", "80",1971,R.drawable.fusca);
        Car car5 = new Car(4,"Lancer", "600",2017,R.drawable.lancer);

        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
        carList.add(car4);
        carList.add(car5);
    }
}
