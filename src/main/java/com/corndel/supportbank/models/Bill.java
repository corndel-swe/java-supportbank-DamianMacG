package com.corndel.supportbank.models;

// DATA MODEL
// Bill

public class Bill {

    private double price;

    public Bill(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double split(double people) {
        return price / people;
    }

    @Override
    public String toString() {
        return "Bill price = " + price;
    }
}

