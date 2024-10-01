package com.corndel.supportbank.controllers;
import com.corndel.supportbank.services.TransactionListService;
import com.corndel.supportbank.services.TransactionService;
import picocli.CommandLine.Command;

@Command(name = "transaction", subcommands = {TransactionService.class, TransactionListService.class})
public class TransactionController {
}
