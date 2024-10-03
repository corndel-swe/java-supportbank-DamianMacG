package com.corndel.supportbank.commands;

import picocli.CommandLine.Command;

@Command(name = "fetch", description = "Fetch the latest exchange rates.")
public class FetchRatesCommand implements Runnable {

    private final FetchExchangeRates fetcher;

    public FetchRatesCommand() {
        this.fetcher = new FetchExchangeRates(); // Initialize your fetcher here
    }

    @Override
    public void run() {
        fetcher.fetchRates(); // Call the fetch method
    }
}
