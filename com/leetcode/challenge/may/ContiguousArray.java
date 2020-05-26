package com.leetcode.challenge.may;

/*
 *
 * Day 26 - Contiguous Array
 * Given a binary array, find the maximum length of a contiguous sub-array with equal number of 0 and 1.
 *
 * Example :
 *
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous sub-array with equal number of 0 and 1.
 *
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous sub-array with equal number of 0 and 1.
 *
 * Note: The length of the given binary array will not exceed 50,000.
 *
 * */


import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> occurrenceCount = new HashMap<>();
        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sum -= 1;

            } else {
                sum += 1;
            }

            if (occurrenceCount.containsKey(sum)) {
                max = Math.max(max, i - occurrenceCount.get(sum));
            } else {
                occurrenceCount.put(sum, i);
            }

            if (sum == 0) {
                max = Math.max(max, i + 1);
            }
        }

        return max;
    }

    public static void main(String args[]) {
        ContiguousArray contiguousArray = new ContiguousArray();
        int[] nums = {0, 1};
        System.out.println(contiguousArray.findMaxLength(nums));

    }
}
