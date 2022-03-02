package com.leetcode.challenge.march22;

import java.util.HashMap;
import java.util.Map;

/*
 * Two sum
 * https://leetcode.com/problems/two-sum/
 * */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> visitedNumbers = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (visitedNumbers.containsKey(delta)) {
                return new int[]{i, visitedNumbers.get(delta)};
            }

            visitedNumbers.put(nums[i], i);
        }

        return new int[]{-1, -1};

    }

    public static void main(String[] args) {
        TwoSum object = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] result = object.twoSum(nums, target);
        System.out.println(result[0] + " " + result[1]);
    }
}
