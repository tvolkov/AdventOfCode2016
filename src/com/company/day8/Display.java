package com.company.day8;

class Display {
    public static int DISPLAY_WIDTH = 50;
    public static int DISPLAY_HEIGHT = 6;

    public static final char OFF = '.';
    public static final char ON = '#';

    private char[][] matrix = new char[DISPLAY_HEIGHT][DISPLAY_WIDTH];

    public Display(){
        for (int i = 0; i < DISPLAY_HEIGHT; i++){
            for (int j = 0; j < DISPLAY_WIDTH; j++){
                matrix[i][j] = OFF;
            }
        }
    }

    public void lightPixel(int x, int y){
        matrix[x][y] = ON;
    }

    public char[] getRow(int y){
        return matrix[y];
    }

    public char[] getColumn(int x){
        char[] column = new char[6];
        for (int i = 0; i < 6; i++){
            column[i] = matrix[i][x];
        }
        return column;
    }


    public void show(){
        System.out.println("start");
        for (int i = 0; i < DISPLAY_HEIGHT; i++){
            for (int j = 0; j < DISPLAY_WIDTH; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void applyColumn(char[] column, int x) {
        for (int i = 0; i < column.length; i++){
            matrix[i][x] = column[i];
        }
    }

    public int getNumberOfPixelsLit(){
        int counter = 0;
        for (int i = 0; i < DISPLAY_HEIGHT; i++){
            for (int j = 0; j < DISPLAY_WIDTH; j++){
                if (matrix[i][j] == '#')
                    counter++;
            }
        }
        return counter;
    }
}
