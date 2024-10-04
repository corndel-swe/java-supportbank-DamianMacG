package com.corndel.supportbank.services;

import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

@Command(name = "convert")
public class CurrencyService implements Runnable {

    @Parameters(index = "0", description = "The amount being converted")
    private double amount;

    @Parameters(index = "1", description = "From currency")
    private String fromCurrency;

    @Parameters(index = "2", description = "To currency")
    private String toCurrency;

    @Override
    public void run() {
        CurrencyConverter currencyConverter = new CurrencyConverter(); // Create an instance of CurrencyConverter
        double convertedAmount;

        try {
            convertedAmount = currencyConverter.convert(amount, fromCurrency, toCurrency); // Call the convert method
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage()); // Print error message
            return;
        }

        String msg = String.format("%.2f %s is equivalent to %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
        System.out.println(msg);
    }
}
