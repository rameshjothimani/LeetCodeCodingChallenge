package com.leetcode.challenge.march22;

/*
* Valid Palindrome
* https://leetcode.com/problems/valid-palindrome/
* */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        s = s.toLowerCase();

        int stringLength = s.length();
        int start = 0;
        int end = stringLength - 1;

        char[] chars = s.toCharArray();

        while (start < end) {
            while (start < stringLength && !Character.isLetterOrDigit(chars[start])) {
                start++;
            }
            while (end >= 0 && !Character.isLetterOrDigit(chars[end])) {
                end--;
            }

            if (start < end && chars[start++] != chars[end--]) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {

        ValidPalindrome validPalindrome=new ValidPalindrome();
        String input="A man, a plan, a canal: Panama";
        if(validPalindrome.isPalindrome(input)){
            System.out.println(input + " ::: This is a palindrome");
        }else {
            System.out.println(input + " ::: This is not a palindrome");
        }

    }
}
