package com.company.day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day7 {
    private static int counter1 = 0;
    private static int counter2 = 0;

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("day7.txt"));
        while (scanner.hasNext()) {
            String next = scanner.next();
            Map<String, Boolean> result = checkIfSupportsTlsAndAba(next);
            if (result.get("supportsTls"))
                counter1++;
            if (result.get("supportsAba"))
                counter2++;
        }
        System.out.println(counter1);
        System.out.println(counter2);
    }


    private static Map<String, Boolean> checkIfSupportsTlsAndAba(String next) {
        List<String> supernetSequences = Arrays.asList(next.split("\\[(.*?)]"));

        List<String> hypernetSequences = new ArrayList<>();
        Pattern p = Pattern.compile("\\[(.*?)]");
        Matcher m = p.matcher(next);
        while (m.find()) {
            hypernetSequences.add(m.group(1));
        }

        boolean abbaInOuterSequence = supernetSequences.stream().anyMatch(Day7::strContainsAbba);
        boolean abbaInhypernetSequence = hypernetSequences.stream().anyMatch(Day7::strContainsAbba);
        boolean checkIfSupportsAba = supernetSequences.stream().anyMatch(str -> containsAbaAndBab(str, hypernetSequences));

        Map<String, Boolean> result = new HashMap<>();
        result.put("supportsTls", abbaInOuterSequence && !abbaInhypernetSequence);
        result.put("supportsAba", checkIfSupportsAba);
        return result;
    }

    private static boolean containsAbaAndBab(String str, List<String> hypernetSequences) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length - 2; i++) {
            if (charArray[i] == charArray[i + 2] && charArray[i] != charArray[i + 1]){
                String aba = String.valueOf(str.substring(i, i + 3));
                String bab = reverseAba(aba);
                if (hypernetSequences.stream().anyMatch(hyperStr -> hyperStr.contains(bab))){
                    return true;
                }
            }
        }
        return false;
    }

    private static String reverseAba(String aba) {
        char[] charStr = aba.toCharArray();
        return new String(new char[]{charStr[1], charStr[0], charStr[1]});
    }

    private static boolean strContainsAbba(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 1; i < charArray.length - 2; i++) {
            if (charArray[i] == charArray[i + 1] && charArray[i - 1] == charArray[i + 2] && charArray[i] != charArray[i - 1]) {
                return true;
            }
        }
        return false;
    }
}
