package com.leetcode.challenge.feb22;
/*
* https://leetcode.com/problems/length-of-last-word/
* */
public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
         //String[] words = s.split(" ");
        //return words.length== 0 ? 0: words[words.length-1].length();

        return s.trim().length()-s.trim().lastIndexOf(" ")-1;

    }
    public static void main(String[] args) {
        LengthOfLastWord object = new LengthOfLastWord();
        System.out.println(object.lengthOfLastWord("Hello World"));
    }

}
