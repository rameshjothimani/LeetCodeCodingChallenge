package com.leetcode.challenge.general;

/*
https://leetcode.com/problems/valid-parentheses/
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
*/

public class ValidParentheses {

    public boolean isValid(String s) {

        char[] stack = new char[s.length() + 1];
        char[] charArray = new char[256];

        charArray[')'] = '(';
        charArray['}'] = '{';
        charArray[']'] = '[';

        int counter = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                counter++;
                stack[counter] = s.charAt(i);
            } else {
                char a = stack[counter];
                counter--;
                if (counter < 0) {
                    return false;
                }
                if (a != charArray[s.charAt(i)]) {
                    return false;
                }
            }

        }
        return counter == 0;

    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("{[]}"));

    }
}
