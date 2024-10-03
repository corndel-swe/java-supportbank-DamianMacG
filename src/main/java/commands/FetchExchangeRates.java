package commands;

import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

public class FetchExchangeRates {

    private final String OPEN_EXCHANGE_RATES_APP_ID;

    // Constructor
    public FetchExchangeRates() {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.load();
        this.OPEN_EXCHANGE_RATES_APP_ID = dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");
    }

    // Method to fetch exchange rates
    public void fetchRates() {
        String url = "https://openexchangerates.org/api/latest.json?app_id=" + OPEN_EXCHANGE_RATES_APP_ID;

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        // Parse the response body
        String json = response.getBody();
        System.out.println("Latest Exchange Rates: " + json);
    }


    public static void main(String[] args) {
        FetchExchangeRates fetcher = new FetchExchangeRates();
        fetcher.fetchRates();
    }
}
