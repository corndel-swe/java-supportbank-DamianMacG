package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Investment;
import picocli.CommandLine;
import picocli.CommandLine.Command;

@Command(name = "simple", description = "Calculate simple interest")
public class InvestmentService implements Runnable {

    // Define parameters for principal, rate, and time
    @CommandLine.Parameters(index = "0", description = "Principal amount")
    private double principal;

    @CommandLine.Parameters(index = "1", description = "Annual interest rate (percentage)")
    private double rate;

    @CommandLine.Parameters(index = "2", description = "Time in years")
    private int time;

    @Override
    public void run() {
        // Create an instance of the Investment model
        Investment investment = new Investment(principal, rate, time);

        // Use the model to calculate interest and total amount
        System.out.println(investment); // toString() of Investment will be called
    }
}
