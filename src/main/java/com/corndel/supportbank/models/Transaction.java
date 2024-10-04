package com.corndel.supportbank.models;

import java.time.LocalDate;

public class Transaction {
    private String date;
    private String from;
    private String to;
    private String narrative;
    private double amount;

    public Transaction(String date, String from, String to, String narrative, double amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getNarrative() {
        return narrative;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format("%s: From %s to %s, Amount: %.2f, Narrative: \"%s\"",
                date, from, to, amount, narrative);
    }
}

