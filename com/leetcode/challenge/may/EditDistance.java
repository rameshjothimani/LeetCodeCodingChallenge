package com.leetcode.challenge.may;


/*
*
* Day 31 -  Edit Distance
*
* Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.
*
* You have the following 3 operations permitted on a word:
* Insert a character
* Delete a character
* Replace a character
*
*
* Input: word1 = "horse", word2 = "ros"
* Output: 3
* Explanation:
*   horse -> rorse (replace 'h' with 'r')
*   rorse -> rose (remove 'r')
*   rose -> ros (remove 'e')
*
*
*
* Input: word1 = "intention", word2 = "execution"
* Output: 5
* Explanation:
*   intention -> inention (remove 't')
*   inention -> enention (replace 'i' with 'e')
*   enention -> exention (replace 'n' with 'x')
*   exention -> exection (replace 'n' with 'c')
*   exection -> execution (insert 'u')
*
*
* */

public class EditDistance {

    public int minDistance(String word1, String word2) {
        int x = word1.length();
        int y = word2.length();
        int[][] occurrenceCount = new int[x + 1][y + 1];
        for (int i = 0; i < x + 1; i++) {
            for (int j = 0; j < y + 1; j++) {
                occurrenceCount[i][j] = -1;
            }
        }

        return findMinDistance(word1, word2, 0, 0, occurrenceCount);
    }

    private int findMinDistance(String word1, String word2, int i, int j, int[][] dp) {
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (i == word1.length()) {
            return dp[i][j] = word2.length() - j;
        }

        if (j == word2.length()) {
            return dp[i][j] = word1.length() - i;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = findMinDistance(word1, word2, i + 1, j + 1, dp);
        }

        return dp[i][j] = 1 + Math.min(findMinDistance(word1, word2, i + 1, j + 1, dp), Math.min(findMinDistance(word1, word2, i + 1, j, dp), findMinDistance(word1, word2, i, j + 1, dp)));
    }

    public static void main(String args[]) {
        EditDistance editDistance = new EditDistance();
        String word1 = "intention";
        String word2 = "execution";

        System.out.println("Minimum Distance : " + editDistance.minDistance(word1, word2));
    }
}
