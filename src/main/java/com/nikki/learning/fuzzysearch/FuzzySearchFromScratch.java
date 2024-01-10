package com.nikki.learning.fuzzysearch;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FuzzySearchFromScratch {

    // Calculate the Levenshtein distance between two strings
    public static int levenshteinDistance(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // Initialize the matrix
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j - 1] + costOfSubstitution(str1.charAt(i - 1), str2.charAt(j - 1)),
                            dp[i - 1][j] + 1,
                            dp[i][j - 1] + 1
                    );
                }
            }
        }

        // The bottom-right cell contains the Levenshtein distance
        return dp[str1.length()][str2.length()];
    }

    // Helper method to determine the cost of substituting one character with another
    private static int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }

    // Helper method to find the minimum value among a set of numbers
    private static int min(int... numbers) {
        return Arrays.stream(numbers).min().orElse(Integer.MAX_VALUE);
    }

    // Perform fuzzy search and return a list of matching strings within a specified threshold
    public static List<String> fuzzySearch(String target, List<String> candidates, int threshold) {
        List<String> matches = new ArrayList<>();

        // Iterate through the candidate strings
        for (String candidate : candidates) {
            // Calculate the Levenshtein distance between the target and each candidate
            int distance = levenshteinDistance(target, candidate);

            // Check if the distance is within the specified threshold
            if (distance <= threshold) {
                // Add the candidate to the list of matches
                matches.add(candidate);
            }
        }

        // Return the list of fuzzy search matches
        return matches;
    }


    public static class Main {
        public static void main(String[] args) {
            List<String> candidates = List.of("apple", "banana", "orange", "grape", "kiwi");

            String target = "ran"; // intentionally misspelled
            int threshold = 3;

            List<String> matches = FuzzySearchFromScratch.fuzzySearch(target, candidates, threshold);

            System.out.println("Fuzzy search results:");
            for (String match : matches) {
                System.out.println(match);
            }
        }
    }
}
