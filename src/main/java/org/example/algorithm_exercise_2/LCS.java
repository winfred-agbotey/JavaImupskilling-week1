package org.example.algorithm_exercise_2;

public class LCS {

    // Method to find the length of LCS and build the LCS string
    public static String findLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        // Create a 2D table to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        // Fill the dp table using bottom-up dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Backtrack through the table to build the LCS string
        StringBuilder lcs = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        return lcs.reverse().toString(); // Reverse the string to get the correct order
    }
}