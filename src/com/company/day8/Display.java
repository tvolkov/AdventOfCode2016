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

    public void turnOff(int x, int y){
        matrix[x][y] = OFF;
    }

    public void show(){
        for (int i = 0; i < DISPLAY_HEIGHT; i++){
            for (int j = 0; j < DISPLAY_WIDTH; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
