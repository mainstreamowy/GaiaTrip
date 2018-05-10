package com.example.dnl.gaiatrip;


import io.realm.RealmObject;

public class Place extends RealmObject{
    private int img;
    private String name;

    private String description;
    private String category;
    private Double latitude;
    private Double longtitude;

    public Place() {
    }

    public Place(int img, String name, String description, String category, Double latitude, Double longtitude) {
        this.img = img;
        this.name = name;

        this.description = description;
        this.category = category;
        this.latitude = latitude;
        this.longtitude = longtitude;
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


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(Double longtitude) {
        this.longtitude = longtitude;
    }

}
