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

    @CommandLine.Parameters(index = "3", description = "Times compounded per year")
    private int timesCompoundedPerYear;

    @Override
    public void run() {
        Investment investment = new Investment(principal, rate, time);

        // Calculate compound interest and total amount
        double interest = investment.calculateCompoundInterest(timesCompoundedPerYear);
        double totalAmount = principal + interest;

        System.out.printf("Investing %.2f at %.2f%% compounded %d times per year for %d years will earn %.2f in interest.%n",
                principal, rate, timesCompoundedPerYear, time, interest);
        System.out.printf("Total amount after %d years: %.2f%n", time, totalAmount);
    }
}
