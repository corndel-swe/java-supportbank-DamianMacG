package com.corndel.supportbank.models;

public class Investment {
    private double principal;
    private double rate;
    private int time;

    public Investment(double principal, double rate, int time) {
        this.principal = principal;
        this.rate = rate;
        this.time = time;
    }

    // Method to calculate simple interest
    public double calculateSimpleInterest() {
        return principal * (rate / 100) * time;
    }

    // Method to calculate total amount (principal + interest)
    public double calculateTotalAmount() {
        return principal + calculateSimpleInterest();
    }

    @Override
    public String toString() {
        return String.format("Investing %.2f at %.2f%% for %d years will earn %.2f in interest.%nTotal amount after %d years: %.2f",
                principal, rate, time, calculateSimpleInterest(), time, calculateTotalAmount());
    }
}
