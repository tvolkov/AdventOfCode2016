package com.company.day8;

import java.util.Map;

class CommandProcessor {
    private Display display = new Display();
    private CommandParser commandParser = new CommandParser();

    public void processCommand(String strCommand){
        Command command = commandParser.parseCommand(strCommand);
        Map<String, Integer> params = command.getParams();
        switch (command.getType()){
            case RECT:
                for (int i = 0; i < params.get("y"); i++){
                    for (int j = 0; j < params.get("x"); j++){
                        display.lightPixel(i, j);
                    }
                }
                break;
            case ROTATE_ROW:
                char[] row = display.getRow(params.get("y"));
                rotateArray(row, params.get("x"));
                break;
            case ROTATE_COLUMN:
                int x = params.get("x");
                char[] column = display.getColumn(x);
                rotateArray(column, params.get("y"));
                display.applyColumn(column, x);
                break;
        }
        display.show();
    }

    public int getNumberOfPixelsLit(){
        return display.getNumberOfPixelsLit();
    }

    private void rotateArray(char[] row, Integer x) {
        for (int i = 0; i < x; i++){
            moveArrayRight(row);
        }
    }

    private void moveArrayRight(char[] row) {
        char buffer = row[row.length - 1];
        for (int i = 0; i < row.length - 1; i++){
            row[row.length - i - 1] = row[row.length - i - 2];
        }
        row[0] = buffer;
    }


}
