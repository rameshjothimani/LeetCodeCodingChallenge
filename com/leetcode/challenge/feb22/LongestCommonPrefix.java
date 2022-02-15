package com.leetcode.challenge.feb22;

/*
* https://leetcode.com/problems/longest-common-prefix/
* */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String prefix= strs[0];
        for(int i=1;i< strs.length;i++){
            while (strs[i].indexOf(prefix) !=0){
                prefix = prefix.substring(0,prefix.length()-1);
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] input={"flower","flow","flight"};
        LongestCommonPrefix object=new LongestCommonPrefix();

        System.out.println(object.longestCommonPrefix(input));
    }
}
