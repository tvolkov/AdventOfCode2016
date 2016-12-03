package com.company.day3;

import java.util.Scanner;

public class Day3_2 {
    public static void main(String[] args) {
        TriangleTester2 triangleTester = new TriangleTester2();
        Scanner scanner = new Scanner(args[0]);
        int counter = 0;
        String[] triangleSides = new String[3];
        while (scanner.hasNext()){
            triangleSides[counter] = scanner.next();
            counter++;
            if (counter == 3) {
                triangleTester.addNextInputRow(triangleSides);
                counter = 0;
            }
        }
        System.out.println(triangleTester.testAllRows());
    }
}
