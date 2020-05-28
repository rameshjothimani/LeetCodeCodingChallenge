package com.leetcode.challenge.may;

/*
*
* Day 28 - Counting Bits
*
* Given a non negative integer number num.
* For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
*
* Example :
* Input: 2
* Output: [0,1,1]
*
* Input: 5
* Output: [0,1,1,2,1,2]
*
* Follow up:
* It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
* Space complexity should be O(n).
* Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
*
* */

public class CountingBits {

    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 1; i < num + 1; i++) {
            //To remove least significant bit for n, AND with n-1
            // n and (n&n-1) differs only by one bit, so just add 1 to get 1 to the result obtained
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }

    public static void main(String args[]) {
        CountingBits countingBits = new CountingBits();
        int[] result = countingBits.countBits(5);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
