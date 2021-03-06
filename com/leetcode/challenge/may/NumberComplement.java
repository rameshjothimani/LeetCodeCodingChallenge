package com.leetcode.challenge.may;

//Day 4

/*
* Number Complement
* Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
*
* Example :
* Input: 5
* Output: 2
* Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
*
*
* Input: 1
* Output: 0
* Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
*
*
* Note:
* The given integer is guaranteed to fit within the range of a 32-bit signed integer.
* You could assume no leading zero bit in the integer’s binary representation.
* This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
* */

public class NumberComplement {
    public int findComplement(int num) {
        //Find the number of bits & make an XOR of input --- 2^bitcount-1
        //E.g:
        /*
        * 5 = 0 0 0 0 0 1 0 1
        * 1 << 3 = 1 0 0 0
        * 1 << 3 - 1 = 0 1 1 1
        *
        * 0101 ^ 0111 = 0010
        *
        * */
        return (((1 << Integer.toBinaryString(num).length()) - 1) ^ num);
    }

    public static void main(String args[]) {
        NumberComplement numberComplement = new NumberComplement();
        System.out.println(numberComplement.findComplement(8));
    }
}
