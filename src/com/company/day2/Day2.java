package com.company.day2;

import java.util.Scanner;

public class Day2 {
    public static void main(String[] args) {
        KeyPadClient keyPadClient = new KeyPadClient();

        Scanner scanner = new Scanner(args[0]);
        while (scanner.hasNext()) {
            for (char c : scanner.next().toCharArray()) {
                keyPadClient.move(c);
            }
            System.out.println(keyPadClient.getKey());
        }
    }

}
