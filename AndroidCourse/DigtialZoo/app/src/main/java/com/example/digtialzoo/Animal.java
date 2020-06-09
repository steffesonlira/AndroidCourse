package com.example.digtialzoo;

public class Animal {

    private int id;
    private String name;
    private String type;
    private int lifeSpan;
    private int image;

    public Animal(int id, String name, String type, int lifeSpan, int image) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.lifeSpan = lifeSpan;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getLifeSpan() {
        return lifeSpan;
    }

    public int getImage() {
        return image;
    }
}
