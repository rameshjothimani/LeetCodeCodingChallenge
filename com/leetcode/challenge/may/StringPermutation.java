package com.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.List;
/*
*
* Day 18 - Permutation in String
*
* Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
* In other words, one of the first string's permutations is the substring of the second string.
*
* Example :
* Input: s1 = "ab" s2 = "eidbaooo"
* Output: True
* Explanation: s2 contains one permutation of s1 ("ba").
*
* Input:s1= "ab" s2 = "eidboaoo"
* Output: False
*
* Note:
* The input strings only contain lower case letters.
* The length of both given strings is in range [1, 10,000].
*
* */


public class StringPermutation {

    public boolean checkInclusion(String s1, String s2) {

        int[] charOccurrence = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charOccurrence[s1.charAt(i) - 'a']++;
        }

        int startIndex = 0;
        int endIndex = 0;
        List<Integer> resultIndexList = new ArrayList<>();

        while (endIndex < s2.length()) {
            //Valid Anagram
            if (charOccurrence[s2.charAt(endIndex) - 'a'] > 0) {
                charOccurrence[s2.charAt(endIndex++) - 'a']--;

                // String Permutation OK
                if (endIndex - startIndex == s1.length()) {
                    resultIndexList.add(startIndex);
                }
            }//Move the window
            else if (startIndex == endIndex) {
                startIndex++;
                endIndex++;
            }//Decrease window size
            else {
                charOccurrence[s2.charAt(startIndex++) - 'a']++;
            }
        }

        if (resultIndexList.size() > 0) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {

        StringPermutation stringPermutation = new StringPermutation();
        String s1 = "ab";
        String s2 = "eidbaooo";
        if (stringPermutation.checkInclusion(s1, s2)) {
            System.out.println("String combination exists");
        } else {
            System.out.println("String combination doesnt exist");
        }
    }
}
