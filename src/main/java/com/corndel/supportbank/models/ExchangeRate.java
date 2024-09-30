package com.corndel.supportbank.models;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {


    public double getRate(String from, String to) {

        if (from.equals("USD") && to.equals("GBP")) {
            return 0.75;
        } else if (from.equals("GBP") && to.equals("USD")) {
            return 1.34;
        } else if (from.equals("EUR") && to.equals("GBP")) {
            return 0.85;
        } else if (from.equals("GBP") && to.equals("EUR")) {
            return 1.18;
        } else {
            throw new IllegalArgumentException("Exchange rate from " + from + " to " + to + " not available.");
        }
    }

    public double convert(String from, String to, double amount) {
        double rate = getRate(from, to);
        return amount * rate;
    }
}