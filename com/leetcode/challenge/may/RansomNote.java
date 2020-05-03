package com.leetcode.challenge.may;
/*
 * Day - 3
 * Ransom Note
 *
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 *
 * Note:
* You may assume that both strings contain only lowercase letters.
* canConstruct("a", "b") -> false
* canConstruct("aa", "ab") -> false
* canConstruct("aa", "aab") -> true
 *
 * */

import java.util.HashMap;
import java.util.Map;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> magazineCharCountMap = new HashMap<>();

        //Add the magazine characters and their occurence count to Map
        for (char magazineChar : magazine.toCharArray()) {
            //If Character already exist , increment the occurence count
            if (magazineCharCountMap.containsKey(magazineChar)) {
                magazineCharCountMap.put(magazineChar, magazineCharCountMap.get(magazineChar) + 1);
            } else {
                //Add a new entry to map if the character doesn't exist already
                magazineCharCountMap.put(magazineChar, 1);
            }
        }
        for (char ransomNoteChar : ransomNote.toCharArray()) {
            //Check if Magazine has the Ransom characters
            if (magazineCharCountMap.containsKey(ransomNoteChar)) {
                //If there is more than one count, decrement the count by 1
                if (magazineCharCountMap.get(ransomNoteChar) > 1) {
                    magazineCharCountMap.put(ransomNoteChar, magazineCharCountMap.get(ransomNoteChar) - 1);
                } else {
                    //If there is only one occurence, remove the character from Map
                    magazineCharCountMap.remove(ransomNoteChar);
                }
            } else {
                return false;
            }
        }
        return true;
    }


    public static void main(String args[]) {
        RansomNote ransomNote = new RansomNote();
        //ransomNote.canConstruct("fffbfg", "effjfggbffjdgbjjhhdegh");
        ransomNote.canConstruct("aa", "aab");
    }
}
