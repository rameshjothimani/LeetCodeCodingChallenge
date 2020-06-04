package com.leetcode.challenge.june;

/*
 * Day 6 - Reverse String
 *
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * You may assume all the characters consist of printable ascii characters.
 *
 * Example:
 *    Input: ["h","e","l","l","o"]
 *    Output: ["o","l","l","e","h"]
 *
 *   Input: ["H","a","n","n","a","h"]
 *   Output: ["h","a","n","n","a","H"]
 *
 * Hint :
 *  The entire logic for reversing a string is based on using the opposite directional two-pointer approach!
 *
 * */

public class ReverseString {

    public void reverseString(char[] s) {
        int charLength = s.length;
        for (int i = 0; i < charLength / 2; i++) {
            char temp = s[i];
            s[i] = s[charLength - i - 1];
            s[charLength - i - 1] = temp;
        }
        System.out.println(new String(s));
    }

    public static void main(String args[]) {
        ReverseString obj = new ReverseString();
        String input = "Hello";
        char[] inputChar = input.toCharArray();
        obj.reverseString(inputChar);
    }
}
