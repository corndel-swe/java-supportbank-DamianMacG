package com.corndel.supportbank.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;
import picocli.CommandLine;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Command;

import java.sql.SQLOutput;

@Command(name = "convert")
public class CurrencyService implements Runnable{

    @Parameters(index = "0", description = "The amount being divided")
    private double amount;

    @Parameters(index = "1", description = "Currency1")
    private String fromCurrency;

    @Parameters(index = "2", description = "Currency2")
    private String toCurrency;

    @Override
    public void run() {
        double convertedAmount = 0;
        try {
            convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (convertedAmount == -1) {
            System.out.println("Error: Invalid currency specified.");
        } else {
            String msg = String.format("%.2f %s is equivalent to %.2f %s", amount, fromCurrency, convertedAmount, toCurrency);
            System.out.println(msg);
        }
    }

    private double convertCurrency(double amount, String fromCurrency, String toCurrency) throws Exception{

        Dotenv dotenv = Dotenv.load();
        String ApiKey = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        String url = String.format("https://openexchangerates.org/api/latest.json?app_id=%s", ApiKey);

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        var tree = mapper.readTree(json);

        if (tree.get("rates").get(fromCurrency) == null || tree.get("rates").get(toCurrency) == null) {
            throw new Exception("Currency does not exist");
        }

        double fromConversion = tree.get("rates")
                .get(fromCurrency).asDouble();

        double toConversion = tree.get("rates")
                .get(toCurrency).asDouble();


        return (amount / fromConversion) * toConversion;
    }
}