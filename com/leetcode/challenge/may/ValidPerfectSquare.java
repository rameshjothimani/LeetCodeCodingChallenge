package com.leetcode.challenge.may;

/*
* Day 9 - Valid Perfect Square
*
* Given a positive integer num, write a function which returns True if num is a perfect square else False.
* Note: Do not use any built-in library function such as sqrt.
*
* Example :
* Input: 16
* Output: true
*
* Input: 14
* Output: false
* */

public class ValidPerfectSquare {

    public boolean isPerfectSquare(int num) {
        //Numbers 0 & 1 are the squares of itself
        if (num < 2) {
            return true;
        }

        long start = 2, end = num;
        while (start <= end) {
            long middleVal = (start + (end - start) / 2);
            long middleValSquare = middleVal * middleVal;
            //Check if the square of middle value = input number
            if (middleValSquare== num) {
                return true;
            } else if (middleValSquare < num) {
                //if square of middle value is smaller than input, then expected square val lies after the current middle value
                start = middleVal + 1;
            } else {
                //if square of middle value is larger than input, then expected square val lies before the current middle value
                end = middleVal - 1;
            }
        }

        return false;

    }

    public static void main(String args[]) {
        ValidPerfectSquare validPerfectSquare = new ValidPerfectSquare();
        if (validPerfectSquare.isPerfectSquare(16)) {
            System.out.println("The given number is a perfect square");
        } else {
            System.out.println("The given number is not a perfect square");
        }
    }
}
