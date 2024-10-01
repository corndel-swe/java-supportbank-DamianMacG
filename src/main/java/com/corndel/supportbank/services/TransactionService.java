package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Command(name = "summarise", description = "Summarises transactions and outputs account balances")
public class TransactionService implements Runnable {

    @Parameters(index = "0", description = "CSV filename containing transactions")
    private String filename;

    @Override
    public void run() {
        Path filePath = Paths.get("src", "data", "transactions", filename);
        List<Transaction> transactions = new ArrayList<>();
        Map<String, Double> accountBalances = new HashMap<>();

        try {
            // Read all lines from the CSV file
            List<String> lines = Files.readAllLines(filePath);

            // Skip the header (start from i = 1)
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] values = line.split(",");

                // Extract transaction details
                String date = values[0];
                String from = values[1];
                String to = values[2];
                String narrative = values[3];
                double amount = Double.parseDouble(values[4]);

                // Create a Transaction object
                Transaction transaction = new Transaction(date, from, to, narrative, amount);
                transactions.add(transaction);

                // Update balances for 'from' and 'to' accounts
                accountBalances.put(from, accountBalances.getOrDefault(from, 0.0) - amount);
                accountBalances.put(to, accountBalances.getOrDefault(to, 0.0) + amount);
            }

            // Output account summaries
            System.out.println("Account Summary:");
            for (Map.Entry<String, Double> entry : accountBalances.entrySet()) {
                System.out.printf("%s: %.2f%n", entry.getKey(), entry.getValue());
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


