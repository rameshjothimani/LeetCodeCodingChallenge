package com.leetcode.challenge.march22;

/*
* Binary Search
* https://leetcode.com/problems/binary-search/
* */
public class BinarySearch {

    public int search(int[] nums, int target) {

        if (nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int midpoint = (left + (right - left) / 2);
            if (nums[midpoint] == target) {
                return midpoint;
            } else if (target < nums[midpoint]) {
                right = midpoint - 1;
            } else {
                left = midpoint + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 3, 4, 7, 8, 9, 11, 13};
        int target = 11;
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("Location of target element :" + binarySearch.search(nums, target));
    }
}
