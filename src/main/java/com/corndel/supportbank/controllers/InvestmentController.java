package com.corndel.supportbank.controllers;

import com.corndel.supportbank.services.InvestmentService;
import picocli.CommandLine.Command;

@Command(name = "invest", subcommands = {InvestmentService.class})
public class InvestmentController {
}

