package com.leetcode.challenge.march22;

/*
 *Find first palindromic string in array
 * https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
 * */
public class FindFirstPalindromicString {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";

    }

    private boolean isPalindrome(String word) {
        int start = 0;
        int end = word.length() - 1;

        while (start < end) {
            if (word.charAt(start) == word.charAt(end)) {
                start++;
                end--;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        FindFirstPalindromicString object = new FindFirstPalindromicString();
        String[] input = {"abc", "car", "ada", "racecar", "cool"};
        String result = object.firstPalindrome(input);
        if (result == "") {
            System.out.println("Given string is not palindrome");
        } else {
            System.out.println("The first palindrome in the given set is : " + result);
        }
    }
}
