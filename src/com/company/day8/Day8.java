package com.company.day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        CommandProcessor commandProcessor = new CommandProcessor();
        Scanner scanner = new Scanner(new FileInputStream("day8-1.txt")).useDelimiter(System.lineSeparator());
        while (scanner.hasNext()){
            commandProcessor.processCommand(scanner.next());
        }
        System.out.println(commandProcessor.getNumberOfPixelsLit());
    }
}
