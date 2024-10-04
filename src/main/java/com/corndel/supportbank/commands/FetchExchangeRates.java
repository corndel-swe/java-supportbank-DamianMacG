package com.corndel.supportbank.commands;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

import java.util.HashMap;
import java.util.Map;

public class FetchExchangeRates {

    private final String OPEN_EXCHANGE_RATES_APP_ID;

    // Constructor
    public FetchExchangeRates() {

        Dotenv dotenv = Dotenv.load();
        this.OPEN_EXCHANGE_RATES_APP_ID = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");
    }


    public void fetchRates() {
        String url = "https://openexchangerates.org/api/latest.json?app_id=" + OPEN_EXCHANGE_RATES_APP_ID;

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();


        String json = response.getBody();

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Double> exchangeRates = new HashMap<>();

        try {
            JsonNode ratesNode = objectMapper.readTree(json).get("rates");

            // Populate the HashMap with key-value pairs
            ratesNode.fieldNames().forEachRemaining(key -> {
                double rate = ratesNode.get(key).asDouble();
                exchangeRates.put(key, rate); // Add to HashMap
            });

            // Print the rates

//            exchangeRates.forEach((currency, rate) -> {
//                System.out.printf("%s: %.6f%n", currency, rate);
//            });

            // Print the entire HashMap
            System.out.println(exchangeRates);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FetchExchangeRates fetcher = new FetchExchangeRates();
        fetcher.fetchRates();
    }
}
