package com.leetcode.challenge.may;

import java.util.HashMap;
import java.util.Map;

/*
*  Day 6 - Majority Element
* Given an array of size n, find the majority element.
* The majority element is the element that appears more than ⌊ n/2 ⌋ times.
* You may assume that the array is non-empty and the majority element always exist in the array.
*
*
* Example :
* Input: [3,2,3]
* Output: 3
*
*
* Input: [2,2,1,1,1,2,2]
* Output: 2
* */


public class MajorityElementFinder {

    public int majorityElement(int[] nums) {
        int occurenceTimes = nums.length / 2;
        HashMap<Integer, Integer> characterOccurrenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (characterOccurrenceMap.containsKey(nums[i])) {
                characterOccurrenceMap.put(nums[i], characterOccurrenceMap.get(nums[i]) + 1);
            } else {
                characterOccurrenceMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : characterOccurrenceMap.entrySet()) {
            if (entry.getValue() > occurenceTimes) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String args[]){
        MajorityElementFinder majorityElementFinder = new MajorityElementFinder();
        int input[]={2,2,1,1,1,2,2};
        System.out.println(majorityElementFinder.majorityElement(input));
    }
}
