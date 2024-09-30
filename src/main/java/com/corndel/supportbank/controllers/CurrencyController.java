package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.CurrencyService;
import picocli.CommandLine.Command;

@Command(name = "currency", subcommands = {CurrencyService.class})
public class CurrencyController {

}