package com.example.nhom8_tuan11.model;

import java.io.Serializable;

public class Item implements Serializable {

    private int id;
    private String name;
    private double price;
    private String date;
    private Category category;

    public Item() {
    }

    public Item(int id, String name, double price, String date, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.category = category;
    }

    public Item(String name, double price, String date, Category category) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.category = category;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
