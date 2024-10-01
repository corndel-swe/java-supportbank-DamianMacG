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
    public double calculateTotalAmountSimple() {
        return principal + calculateSimpleInterest();
    }

    public double calculateCompoundInterest(int timesCompoundedPerYear) {
        return principal * Math.pow((1 + (rate / 100) / timesCompoundedPerYear), timesCompoundedPerYear * time) - principal;
    }

    // Method to calculate total amount with compound interest
    public double calculateTotalAmountCompound(int timesCompoundedPerYear) {
        return principal * Math.pow((1 + (rate / 100) / timesCompoundedPerYear), timesCompoundedPerYear * time);
    }

    @Override
    public String toString() {
        return String.format("Investing %.2f at %.2f%% for %d years will earn %.2f in interest.%nTotal amount after %d years: %.2f",
                principal, rate, time, calculateSimpleInterest(), time, calculateTotalAmountSimple());
    }
}
