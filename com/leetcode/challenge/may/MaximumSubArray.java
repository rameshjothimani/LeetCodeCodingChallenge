package com.leetcode.challenge.may;

/*
*
* Maximum Subarray
*
* Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
*
* Input: [-2,1,-3,4,-1,2,1,-5,4],
* Output: 6
* Explanation: [4,-1,2,1] has the largest sum = 6.
*
* */
public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            maxSum = Math.max(currentSum, maxSum);
            currentSum = Math.max(currentSum, 0);
        }

        return maxSum;

    }

    public static void main(String args[]) {
        MaximumSubArray maximumSubArray = new MaximumSubArray();
        int input[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maximumSubArray.maxSubArray(input));
    }
}
