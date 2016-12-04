package com.company.day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class Day4 {
    private static int sumOfIds = 0;
    private static List<RoomDetails> realRooms = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream("day4_1.txt"));
        while (scanner.hasNext()){
            testLine(scanner.next());
        }
        System.out.println(sumOfIds);
        processRealRooms();
    }

    private static void processRealRooms() {
        for (RoomDetails  roomDetails : realRooms){
            String shifted = doRotate(roomDetails.name, roomDetails.sectorId);
            if (shifted.contains("north")){
                System.out.printf(shifted);
                System.out.printf(roomDetails.sectorId);
            }
        }
    }

    private static String doRotate(String name, String sectorId) {
        int shift = Integer.parseInt(sectorId);
        StringBuilder result = new StringBuilder();
        for (char c : name.toCharArray()){
                result.append((char)((((c - 'a') + shift ) % 26) + 'a'));
//            }
        }
        return result.toString();
    }

    private static void testLine(String line) {
        RoomDetails roomDetails = tokenizeLine(line);
        final Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : roomDetails.name.toCharArray()){
            if (c != '-'){
                frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
            }
        }
        String mostCommonChars = frequencies.entrySet().stream().sorted(Map.Entry.comparingByKey())
                                                                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                                                                .limit(5)
                                                                .map(Map.Entry::getKey)
                                                                .map(ch -> Character.toString(ch))
                                                                .collect(Collectors.joining(""));
        if (mostCommonChars.equals(roomDetails.checksum)){
            sumOfIds += Integer.parseInt(roomDetails.sectorId);
            realRooms.add(roomDetails);
        }
    }

    private static RoomDetails tokenizeLine(String line) {
        int checksumStartIndex = line.indexOf('[');
        String checksum = line.substring(checksumStartIndex).substring(1, 6);
        String tmpLine = line.substring(0, checksumStartIndex);
        int sectorIdStartIndex = line.lastIndexOf('-');
        String name = tmpLine.substring(0, sectorIdStartIndex);
        String sectorId = tmpLine.substring(sectorIdStartIndex + 1);
        return new RoomDetails(name, sectorId, checksum);
    }

    private static class RoomDetails {
        public RoomDetails(String name, String sectorId, String checksum) {
            this.name = name;
            this.sectorId = sectorId;
            this.checksum = checksum;
        }

        String name;
        String sectorId;
        String checksum;
    }
}
