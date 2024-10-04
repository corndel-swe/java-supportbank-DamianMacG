package com.corndel.supportbank;

import com.corndel.supportbank.commands.FetchRatesCommand;
import com.corndel.supportbank.controllers.BillController;
import com.corndel.supportbank.controllers.CurrencyController;
import com.corndel.supportbank.controllers.InvestmentController;
import com.corndel.supportbank.controllers.TransactionController;
import com.corndel.supportbank.services.InvestmentService;
import kong.unirest.Unirest;
import picocli.CommandLine;
import io.github.cdimascio.dotenv.Dotenv;

import java.util.Arrays;

import picocli.CommandLine.Command;


@Command(name = "supportbank", subcommands = {BillController.class, CurrencyController.class, InvestmentController.class, TransactionController.class, FetchRatesCommand.class})
public class SupportBank implements Runnable {


  public static void main(String[] args) {
    CommandLine commandLine = new CommandLine(new SupportBank());
    System.out.println(Arrays.toString(args));
    int exitCode = commandLine.execute(args);
    System.exit(exitCode);
  }

  @Override
  public void run() {
    System.out.println("Welcome to the support bank!");
  }
}
