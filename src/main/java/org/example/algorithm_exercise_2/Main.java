package org.example.algorithm_exercise_2;

import static org.example.algorithm_exercise_2.LCS.findLCS;

public class Main {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        String lcs = findLCS(s1, s2);
        System.out.println("Longest Common Subsequence: " + lcs);
    }
}
