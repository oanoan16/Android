package com.example.recycleview_crud.model;

public class Cat {
    private int img;
    private double price;
    private String name, description;

    public Cat() {
    }

    public Cat(int img, double price, String name, String description) {
        this.img = img;
        this.price = price;
        this.name = name;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
