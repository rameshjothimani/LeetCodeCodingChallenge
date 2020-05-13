package com.leetcode.challenge.may;

import java.util.Stack;
/*
 * Day - 13
 *
 * Remove K Digits
 *
 * Given a non-negative integer num represented as a string,
 * remove k digits from the number so that the new number is the smallest possible.
 * Note:
 * The length of num is less than 10002 and will be ≥ k.
 * The given num does not contain any leading zero.
 *
 * Example 1:
 * Input: num = "1432219", k = 3
 * Output: "1219"
 * Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 *
 *
 * Example 2:
 * Input: num = "10200", k = 1
 * Output: "200"
 * Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 * Example 3:
 * Input: num = "10", k = 2
 * Output: "0"
 * Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 * */

public class SmallestPossibleNo {

    public String removeKdigits(String num, int k) {

        //It means all elements would be removed
        if (k == num.length()) {
            return "0";
        }

        //Nothing needs to be removed
        if (k == 0) {
            return num;
        }

        Stack<Character> charStack = new Stack<>();
        for (Character character : num.toCharArray()) {
            //Check if element is there in stack & it's greater than the character coming in
            while (!charStack.isEmpty() && k > 0 && charStack.peek() > character) {
                charStack.pop();
                k--;
            }
            charStack.push(character);
        }

        //If there are still some elements to be deleted, ideally it should be located at the last
        while (k-- > 0) {
            charStack.pop();
        }

        StringBuilder outputString = new StringBuilder();
        while (!charStack.isEmpty()) {
            outputString.append(charStack.pop());
        }

        //Since it's stack, the stored order will be reverse - LIFO
        outputString.reverse();

        //Remove the Zeroes at the starting
        while (outputString.length() > 1 && outputString.charAt(0) == '0') {
            outputString.deleteCharAt(0);
        }


        return outputString.toString();

    }


    public static void main(String args[]) {
        SmallestPossibleNo smallestPossibleNo = new SmallestPossibleNo();
        String num = "10200";
        int k = 1;
        System.out.println(smallestPossibleNo.removeKdigits(num, k));
    }
}
