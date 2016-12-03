package com.company.day3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TriangleTester {
    protected int counter = 0;

    public void test(Integer[] sides){
        Map<Integer, Integer> sumsOfSides = getSumsOfSides(sides);
        for (Map.Entry<Integer, Integer> sidesEntry : sumsOfSides.entrySet()){
            if (sidesEntry.getKey() >= sidesEntry.getValue())
                return;
        }
        counter++;
    }

    private Map<Integer, Integer> getSumsOfSides(Integer[] intSides) {

        Map<Integer, Integer> sums = new HashMap<>();
        for (int i = 0; i < intSides.length; i++){
            final Integer currentSide = intSides[i];
            final Integer[] twoOtherSides = extractTwoOtherSides(intSides, currentSide);
            sums.put(currentSide, Arrays.stream(toInt(twoOtherSides)).sum());
        }
        return sums;
    }

    private int[] toInt(Integer[] twoOtherSides) {
        int[] result = new int[twoOtherSides.length];
        for (int i = 0; i < twoOtherSides.length; i++){
            result[i] = twoOtherSides[i];
        }
        return result;
    }

    private Integer[] extractTwoOtherSides(Integer[] intSides, int currentSide) {

        int currentSideIndex = Arrays.asList(intSides).indexOf(currentSide);
        if (currentSideIndex != 0){
            swapCurrentSideAndFirst(intSides, currentSideIndex, 0);
        }
        Integer[] result = new Integer[2];
        System.arraycopy(intSides, 1, result, 0, 2);
        return result;
    }

    private void swapCurrentSideAndFirst(Integer[] intSides, int currentSideIndex, int i) {
        int tmp = intSides[currentSideIndex];
        intSides[currentSideIndex] = intSides[i];
        intSides[i] = tmp;
    }

    public int getCounterValue(){
        return counter;
    }
}
