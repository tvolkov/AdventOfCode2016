package com.company.day3;

import java.util.*;

public class Day3 {
    public static void main(String[] args) {
        TriangleTester triangleTester = new TriangleTester();
        Scanner scanner = new Scanner(args[0]);
        int counter = 0;
        String[] triangleSides = new String[3];
        while (scanner.hasNext()){
            triangleSides[counter] = scanner.next();
            counter++;
            if (counter == 3) {
                triangleTester.test(convertInputToInteger(triangleSides));
                counter = 0;
            }
        }

        System.out.println(triangleTester.getCounterValue());
    }

    protected static Integer[] convertInputToInteger(String[] sides) {
        Integer[] intSides = new Integer[3];
        for (int i = 0; i < sides.length; i++){
            intSides[i] = Integer.valueOf(sides[i]);
        }
        return  intSides;
    }
}