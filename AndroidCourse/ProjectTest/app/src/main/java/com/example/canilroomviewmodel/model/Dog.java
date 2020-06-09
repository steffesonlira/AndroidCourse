package com.example.canilroomviewmodel.model;

import androidx.annotation.Nullable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties({"bred_for", "breed_group", "temperament", "life_span", "alt_names", "wikipedia_url",
        "origin", "country_code", "imperial", "metric"})


public class Dog implements Serializable {


    private int id;
    private String name;
    private int image;
    @JsonProperty("weight")
    private Map<String,Object> weight = new HashMap<>();
    private Map<String,Object> height = new HashMap<>();

    public Dog(int id, String name, HashMap<String,Object> weight, HashMap<String,Object> height, int image) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.image = image;
    }

    public Dog() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Object> getWeight() {
        return weight;
    }

    public void setWeight(Map<String, Object> weight) {
        this.weight = weight;
    }

    public Map<String, Object> getHeight() {
        return height;
    }

    public void setHeight(Map<String, Object> height) {
        this.height = height;
    }
}
