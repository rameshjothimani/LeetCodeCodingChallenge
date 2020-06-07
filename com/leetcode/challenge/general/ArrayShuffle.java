package com.leetcode.challenge.general;

import java.util.Arrays;

/*
 * https://leetcode.com/problems/shuffle-the-array/
 * 1470. Shuffle the Array
 *
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
 * Return the array in the form [x1,y1,x2,y2,...,xn,yn].
 *
 * Input: nums = [2,5,1,3,4,7], n = 3
 * Output: [2,3,5,4,1,7]
 * Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
 *
 * Input: nums = [1,2,3,4,4,3,2,1], n = 4
 * Output: [1,4,2,3,3,2,4,1]
 *
 * Input: nums = [1,1,2,2], n = 2
 * Output: [1,2,1,2]
 *
 * Constraints:
 *  1 <= n <= 500
 *  nums.length == 2n
 *  1 <= nums[i] <= 10^3
 *
 * */
public class ArrayShuffle {

    public int[] shuffle(int[] nums, int n) {

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                result[i] = nums[i / 2];
            } else {
                result[i] = nums[n + i / 2];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayShuffle arrayShuffle = new ArrayShuffle();
        int[] nums = {2, 5, 1, 3, 4, 7};
        int n = 3;

        int[] result = arrayShuffle.shuffle(nums, n);
        System.out.println(Arrays.toString(result));
    }
}
