package com.leetcode.challenge.march22;

public class MaxSubArray {
 /*
 * Maximum Sub-Array
 * https://leetcode.com/problems/maximum-subarray/
 * */
    public int maxSubArray(int[] nums) {
        /*int tillNow = nums[0];
        int tillEnd = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tillNow = Math.max(nums[i], nums[i] + tillNow);
            tillEnd = Math.max(tillEnd, tillNow);
        }

        return tillEnd;*/

        int currentMaximum = 0;
        int globalMaximum = Integer.MIN_VALUE;

        for (int num : nums) {
            currentMaximum = Math.max(currentMaximum + num, num);
            globalMaximum = Math.max(globalMaximum, currentMaximum);
        }

        return globalMaximum;
    }

    public static void main(String[] args) {
        int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        MaxSubArray object = new MaxSubArray();
        System.out.println(object.maxSubArray(input));
    }
}

