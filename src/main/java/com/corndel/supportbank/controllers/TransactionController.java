package com.corndel.supportbank.controllers;
import com.corndel.supportbank.services.TransactionService;
import picocli.CommandLine.Command;

@Command(name = "transaction", subcommands = {TransactionService.class})
public class TransactionController {
}
