package com.corndel.supportbank.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

public class CurrencyConverter {

    private final String apiKey;
    private final ObjectMapper objectMapper;

    public CurrencyConverter() {
        Dotenv dotenv = Dotenv.load();
        this.apiKey = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");
        this.objectMapper = new ObjectMapper();
    }


    public double convert(double amount, String fromCurrency, String toCurrency) throws Exception {
        String url = String.format("https://openexchangerates.org/api/latest.json?app_id=%s", apiKey);

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();
        JsonNode ratesNode = objectMapper.readTree(json).get("rates");

        if (ratesNode.get(fromCurrency) == null || ratesNode.get(toCurrency) == null) {
            throw new Exception("Error sozziiiii");
        }

        double fromConversion = ratesNode.get(fromCurrency).asDouble();
        double toConversion = ratesNode.get(toCurrency).asDouble();

        return (amount / fromConversion) * toConversion;
    }
}
