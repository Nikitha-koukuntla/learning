package com.nikki.learning.fuzzysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FuzzySearchEngine {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("test");
        strings.add("subject");
        strings.add("Student");
        strings.add("water");
        strings.add("Burger");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the substring to search for: ");
        String targetSubstring = scanner.nextLine();

        List<String> matchingStrings = fetchString(strings, targetSubstring);

        System.out.println("Strings containing substring and targetSubstring ");
        for (String matchingString : matchingStrings) {
            System.out.println(matchingString);
        }

        // Close the scanner to prevent resource leak
        scanner.close();
    }

    public static List<String> fetchString(List<String> strings, String substring) {
        List<String> matchingStrings = new ArrayList<>();

        for (String str : strings) {
            // Check if the current string contains the target substring
            if (str.contains(substring)) {
                matchingStrings.add(str);
            }
        }

        return matchingStrings;
    }
}
