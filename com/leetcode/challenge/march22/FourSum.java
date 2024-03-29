package com.leetcode.challenge.march22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 4Sum
* https://leetcode.com/problems/4sum/
* */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum < target) {
                        left++;
                    } else if (sum > target) {
                        right--;
                    } else {
                        List<Integer> combination = new ArrayList<>();
                        combination.add(nums[i]);
                        combination.add(nums[j]);
                        combination.add(nums[left]);
                        combination.add(nums[right]);

                        result.add(combination);

                        left++;
                        right--;

                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        FourSum object = new FourSum();
        int[] input = {1, 0, -1, 0, -2, 2};
        int target = 0;

        List<List<Integer>> resultList = object.fourSum(input, target);
        for (List<Integer> temp : resultList) {
            temp.forEach(System.out::println);
            System.out.println("*****");
        }
    }
}
