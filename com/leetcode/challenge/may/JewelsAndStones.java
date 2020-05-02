package com.leetcode.challenge.may;
// Jewels and Stones
/*
* You're given strings J representing the types of stones that are jewels, and S representing the stones you have.
* Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
* The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".
*/
/*
* Example :
*
* Input: J = "aA", S = "aAAbbbb"
* Output: 3
*
* Input: J = "z", S = "ZZ"
* Output: 0
*
* */

/* Note:
* S and J will consist of letters and have length at most 50.
* The characters in J are distinct.*
* */

public class JewelsAndStones {

    public int numJewelsInStones(String J, String S) {
        char[] jewel = J.toCharArray();
        char[] stone = S.toCharArray();
        int result = 0;

        for (int i = 0; i < jewel.length; i++) {
            for (int j = 0; j < stone.length; j++) {
                if (jewel[i] == stone[j]) {
                    result += 1;
                }
            }
        }
        return result;

    }

    public static void main(String args[]) {
        JewelsAndStones jewelsAndStones = new JewelsAndStones();
        int result = jewelsAndStones.numJewelsInStones("aA", "aAAABC");
        System.out.println("Result : " + result);
    }

}
