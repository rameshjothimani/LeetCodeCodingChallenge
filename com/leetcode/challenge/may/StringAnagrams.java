package com.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.List;

/*
 * Day 17 - Find All Anagrams in a String
 *
 *Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * The order of output does not matter.
 *
 * Examples :
 *
 * Input:
 * s: "cbaebabacd" p: "abc"
 * Output:
 *   [0, 6]
 *
 * Explanation:
 * The substring with start index = 0 is "cba", which is an anagram of "abc".
 * The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 *
 * Input:
 * s: "abab" p: "ab"

 * Output:
 * [0, 1, 2]

 * Explanation:
 * The substring with start index = 0 is "ab", which is an anagram of "ab".
 * The substring with start index = 1 is "ba", which is an anagram of "ab".
 * The substring with start index = 2 is "ab", which is an anagram of "ab".
 *
 * */

public class StringAnagrams {

    public List<Integer> findAnagrams(String s, String p) {

        String inputString = s;
        String anagramString = p;
        if (inputString == null || inputString.length() == 0 || inputString.length() < anagramString.length()) {
            return new ArrayList<>();
        }

        int[] charOccurrence = new int[26];
        for (int i = 0; i < anagramString.length(); i++) {
            charOccurrence[anagramString.charAt(i) - 'a']++;
        }

        int startIndex = 0;
        int endIndex = 0;
        List<Integer> resultIndexList = new ArrayList<>();

        while (endIndex < inputString.length()) {
            //Valid Anagram
            if (charOccurrence[inputString.charAt(endIndex) - 'a'] > 0) {
                charOccurrence[inputString.charAt(endIndex++) - 'a']--;

                // window size equal to size input anagram string (p) to check. Anagram Found
                if (endIndex - startIndex == anagramString.length()) {
                    resultIndexList.add(startIndex);
                }
            }//Move the window
            else if (startIndex == endIndex) {
                startIndex++;
                endIndex++;
            }//Decrease window size
            else {
                charOccurrence[inputString.charAt(startIndex++) - 'a']++;
            }
        }


        return resultIndexList;
    }

    public static void main(String args[]) {

        StringAnagrams stringAnagrams = new StringAnagrams();
        String input = "cbaebabacd";
        String searchString = "abc";
        List<Integer> resultList = stringAnagrams.findAnagrams(input, searchString);
        for (Integer i : resultList) {
            System.out.println("Starting Index of Anagram: " + i);
        }
    }
}
