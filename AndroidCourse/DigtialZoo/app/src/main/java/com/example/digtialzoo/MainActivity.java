package com.example.digtialzoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Animal> animalList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        populateAnimalsList();

        AnimalListAdapter adapter = new AnimalListAdapter(animalList);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setAdapter(adapter);

    }

    private void populateAnimalsList(){
        Animal animal1 = new Animal(0,"Suricato", "Mamifero",8,R.drawable.animal1);
        Animal animal2 = new Animal(1,"Tigre", "Felino",12,R.drawable.animal2);
        Animal animal3 = new Animal(2,"Lemure", "Felino",234,R.drawable.animal3);
        Animal animal4 = new Animal(3,"Boi", "Mamifero",50,R.drawable.animal4);
        Animal animal5 = new Animal(4,"Cachorro", "Mamifero",17,R.drawable.animal5);
        Animal animal6 = new Animal(5,"Garca", "Ave",18,R.drawable.animal6);
        Animal animal7 = new Animal(0,"Suricato", "Mamifero",8,R.drawable.animal1);
        Animal animal8 = new Animal(1,"Tigre", "Felino",12,R.drawable.animal2);
        Animal animal9 = new Animal(2,"Lemure", "Felino",234,R.drawable.animal3);
        Animal animal10 = new Animal(3,"Boi", "Mamifero",50,R.drawable.animal4);
        Animal animal11 = new Animal(4,"Cachorro", "Mamifero",17,R.drawable.animal5);
        Animal animal12 = new Animal(5,"Garca", "Ave",18,R.drawable.animal6);
        Animal animal13 = new Animal(0,"Suricato", "Mamifero",8,R.drawable.animal1);
        Animal animal41 = new Animal(1,"Tigre", "Felino",12,R.drawable.animal2);
        Animal animal51 = new Animal(2,"Lemure", "Felino",234,R.drawable.animal3);
        Animal animal61 = new Animal(3,"Boi", "Mamifero",50,R.drawable.animal4);
        Animal animal71 = new Animal(4,"Cachorro", "Mamifero",17,R.drawable.animal5);
        Animal anima20 = new Animal(5,"Garca", "Ave",18,R.drawable.animal6);
        Animal anima21 = new Animal(0,"Suricato", "Mamifero",8,R.drawable.animal1);
        Animal animal81 = new Animal(1,"Tigre", "Felino",12,R.drawable.animal2);
        Animal animal91 = new Animal(2,"Lemure", "Felino",234,R.drawable.animal3);
        Animal animal101 = new Animal(3,"Boi", "Mamifero",50,R.drawable.animal4);
        Animal animal111 = new Animal(4,"Cachorro", "Mamifero",17,R.drawable.animal5);
        Animal animal121 = new Animal(5,"Garca", "Ave",18,R.drawable.animal6);


        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);
        animalList.add(animal6);
        animalList.add(animal7);
        animalList.add(animal8);
        animalList.add(animal9);
        animalList.add(animal10);
        animalList.add(animal1);
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);
        animalList.add(animal6);
        animalList.add(animal7);
        animalList.add(animal8);
        animalList.add(animal9);
        animalList.add(animal10);
        animalList.add(animal1);
        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);
        animalList.add(animal6);
        animalList.add(animal7);
        animalList.add(animal8);
        animalList.add(animal9);
        animalList.add(animal10);
        animalList.add(animal1);
    }

}
