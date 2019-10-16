package com.example.yash.bot;

import com.google.firebase.firestore.Exclude;

import java.io.Serializable;

public class Product implements Serializable{
    @Exclude private String id;
    private String name, brand, description,rackname;
    private double price;
    private int qty;
    private String offer;


    public Product(){

    }




    public Product(String name, String rackname, String brand, String offer, String description, double price, int qty) {
        this.name = name;
        this.rackname=rackname;
        this.offer=offer;
        this.brand = brand;
        this.description = description;
        this.price = price;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public String getRackname() {
        return rackname;
    }




    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getOffer() {
        return offer;
    }
}