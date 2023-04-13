package com.example.chuong4.model;

public class Technology {
    private int img;
    private String name, sub, mota;

    public Technology(int img, String name, String sub, String mota) {
        this.img = img;
        this.name = name;
        this.sub = sub;
        this.mota = mota;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
