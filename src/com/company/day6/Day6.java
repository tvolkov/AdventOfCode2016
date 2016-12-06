package com.company.day6;

import java.util.*;

public class Day6 {

    private static List<Map<Character, Integer>> frequencies = new LinkedList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++){
            frequencies.add(new TreeMap<>());
        }
        Scanner scanner = new Scanner(args[0]);
        while (scanner.hasNext()){
            processNextLine(scanner.next());
        }
        System.out.println(findMessage1());
        System.out.println(findMessage2());
    }

    private static String findMessage1() {
        String result = "";
        for (Map<Character, Integer> map : frequencies){
            Map.Entry<Character, Integer> maxEntry = null;
            for (Map.Entry<Character, Integer> entry : map.entrySet()){
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) >= 0){
                    maxEntry = entry;
                }
            }
            result += maxEntry.getKey();
        }
        return result;
    }

    private static String findMessage2() {
        String result = "";
        for (Map<Character, Integer> map : frequencies){
            Map.Entry<Character, Integer> minEntry = null;
            for (Map.Entry<Character, Integer> entry : map.entrySet()){
                if (minEntry == null || entry.getValue().compareTo(minEntry.getValue()) <= 0){
                    minEntry = entry;
                }
            }
            result += minEntry.getKey();
        }
        return result;
    }

    private static void processNextLine(String next) {
        char[] charArray = next.toCharArray();
        for (int i = 0; i < charArray.length; i++){
            int charFreq = frequencies.get(i).getOrDefault(charArray[i], 0);
            frequencies.get(i).put(charArray[i], charFreq + 1);
        }
    }
}
