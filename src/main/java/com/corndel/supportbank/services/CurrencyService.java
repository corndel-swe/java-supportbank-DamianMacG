package com.corndel.supportbank.services;

import com.corndel.supportbank.models.ExchangeRate;
import picocli.CommandLine;

@CommandLine.Command(name = "convert")
public class CurrencyService implements Runnable {
    @CommandLine.Parameters(index = "0")
    private double amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;

    @Override
    public void run() {
        ExchangeRate exchangeRate = new ExchangeRate();
        double rate = exchangeRate.getRate(from, to);
        double convertedAmount = exchangeRate.convert(from, to, amount);

        System.out.printf("Converting %.2f %s to %.2f %s at an exchange rate of %.2f%n",
                amount, from, convertedAmount, to, rate);
    }
}