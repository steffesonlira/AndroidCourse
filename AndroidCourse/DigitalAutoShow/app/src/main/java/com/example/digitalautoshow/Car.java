package com.example.digitalautoshow;

public class Car {

    private int id;
    private String name;
    private String hp;
    private int manufacturing;
    private int image;

    public Car(int id, String name, String hp, int manufacturing, int image) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.manufacturing = manufacturing;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHp() {
        return hp;
    }

    public int getManufacturing() {
        return manufacturing;
    }

    public int getImage() {
        return image;
    }
}
