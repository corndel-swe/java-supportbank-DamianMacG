package com.corndel.supportbank.exercises;

 import picocli.CommandLine;
 import picocli.CommandLine.Command;
 import picocli.CommandLine.Parameters;

@Command(name = "hello", description = "Hello World CLI")

public class HelloWorld implements Runnable{



    @Override
    public void run() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        CommandLine cli = new CommandLine(new HelloWorld());
        int exitCode = cli.execute(args);
        System.exit(exitCode);
    }



}
