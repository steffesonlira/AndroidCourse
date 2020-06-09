package com.example.recyclerviewlayout;

public class Contact {

    private String name;
    private String job;
    private int imageResources;


    public Contact(String name, String job, int imageResources) {
        this.name = name;
        this.job = job;
        this.imageResources = imageResources;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getImageResources() {
        return imageResources;
    }
}
