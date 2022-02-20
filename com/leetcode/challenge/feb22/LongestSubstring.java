package com.leetcode.challenge.feb22;

import java.util.HashSet;
import java.util.Set;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;

        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length()) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(j));
                ++j;
            }
            set.add(c);
            max = Math.max(max, i - j + 1);
            ++i;
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstring object = new LongestSubstring();
        System.out.println(object.lengthOfLongestSubstring("abcabcbb"));
    }


}
