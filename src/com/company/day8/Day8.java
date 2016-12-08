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
    }

    private static class CommandProcessor {
        private Display display = new Display();
        private CommandParser commandParser = new CommandParser();

        public void processCommand(String strCommand){
            Command command = commandParser.parseCommand(strCommand);
            switch (command.getType()){
                case RECT:
                    for (int i = 0; i < command.getParams().get("y"); i++){
                        for (int j = 0; j < command.getParams().get("x"); j++){
                            display.lightPixel(i, j);
                        }
                    }

            }
            display.show();
        }


    }

}
