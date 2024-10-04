package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Command(name = "list", description = "Lists transactions for a specific account")
public class TransactionListService implements Runnable {

    @Parameters(index = "0", description = "CSV filename containing transactions")
    private String filename;

    @Parameters(index = "1", description = "Account name to list transactions for")
    private String accountName;

    @Override
    public void run() {
        Path filePath = Paths.get("src", "data", "transactions", filename);
        List<Transaction> transactions = new ArrayList<>();

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
            }

            // Filter transactions for the specified account
            for (Transaction transaction : transactions) {
                if (transaction.getFrom().equals(accountName) || transaction.getTo().equals(accountName)) {
                    System.out.println(transaction);
                }
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }
}


