package com.leetcode.challenge.march22;


/*
* Search insert position
* https://leetcode.com/problems/search-insert-position/
* */
public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {

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

        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
        int[] nums = {1,3,5,6};
        int target = 7;
        System.out.println(searchInsertPosition.searchInsert(nums, target));
    }
}
