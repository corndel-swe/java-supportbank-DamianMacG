package com.corndel.supportbank.exercises;

 import picocli.CommandLine;
 import picocli.CommandLine.Command;
 import picocli.CommandLine.Parameters;

@Command(name = "hello", description = "Hello World CLI", subcommands = {ColorCommand.class})

public class HelloWorld implements Runnable{

    @Parameters(index = "0", defaultValue = "World")
    private String name;

    @Override
    public void run() {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        CommandLine cli = new CommandLine(new HelloWorld());
        int exitCode = cli.execute(args);
        System.exit(exitCode);
    }



}
