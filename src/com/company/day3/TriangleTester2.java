package com.company.day3;

import java.util.LinkedList;
import java.util.List;

public class TriangleTester2 {
    private List<Integer> column1 = new LinkedList<>();
    private List<Integer> column2 = new LinkedList<>();
    private List<Integer> column3 = new LinkedList<>();
    public void addNextInputRow(String[] sides){
        Integer[] intSides = convertInputToInteger(sides);
        column1.add(intSides[0]);
        column2.add(intSides[1]);
        column3.add(intSides[2]);
    }

    protected Integer[] convertInputToInteger(String[] sides) {
        Integer[] intSides = new Integer[3];
        for (int i = 0; i < sides.length; i++){
            intSides[i] = Integer.valueOf(sides[i]);
        }
        return  intSides;
    }

    public int testAllRows(){
        TriangleTester tester = new TriangleTester();
        int counter = 0;
        Integer[] triangle = new Integer[3];
        for (Integer integer : column1){
            triangle[counter] = integer;
            counter++;
            if (counter == 3){
                tester.test(triangle);
                counter = 0;
            }

        }
        counter = 0;
        for (Integer integer : column2){
            triangle[counter] = integer;
            counter++;
            if (counter == 3){
                tester.test(triangle);
                counter = 0;
            }
        }
        counter = 0;
        for (Integer integer : column3){
            triangle[counter] = integer;
            counter++;
            if (counter == 3){
                tester.test(triangle);
                counter = 0;
            }
        }
        return tester.getCounterValue();
    }
}
