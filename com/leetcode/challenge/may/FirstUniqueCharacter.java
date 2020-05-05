package com.leetcode.challenge.may;

import java.util.HashMap;

/*
* Day 5 - First Unique Character in a String
*
*Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*
* Example :
* s = "leetcode"
* return 0.

* s = "loveleetcode",
* return 2.
*
* Note: You may assume the string contain only lowercase letters.
* */

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> characterOccurrenceMap = new HashMap<>();

        //Iterate the string & check character by character. Add it to Hashmap
        for (int i = 0; i < s.length(); i++) {
            if (characterOccurrenceMap.containsKey(s.charAt(i))) {
                characterOccurrenceMap.put(s.charAt(i), -1);
            } else {
                characterOccurrenceMap.put(s.charAt(i), i);
            }
        }

        int minimumValue = Integer.MAX_VALUE;
        for (Character c : characterOccurrenceMap.keySet()) {
            if (characterOccurrenceMap.get(c) > -1 && characterOccurrenceMap.get(c) < minimumValue) {
                minimumValue = characterOccurrenceMap.get(c);
            }
        }

        //If none of the characters is Unique, return -1
        if (minimumValue == Integer.MAX_VALUE) {
            return -1;
        }

        return minimumValue;
    }

    public static void main(String args[]){
        FirstUniqueCharacter firstUniqueCharacter = new FirstUniqueCharacter();
        System.out.println(firstUniqueCharacter.firstUniqChar("loveleetcode"));
    }
}
