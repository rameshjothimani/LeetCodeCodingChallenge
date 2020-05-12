package com.leetcode.challenge.may;
/*
 *
 * Day - 12
 *
 * Single Element in a Sorted Array
 *You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example :
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * */

public class SingleElement {

    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 1; // Length count starts from 1

        while (start < end) {

            int mid = start + (end - start) / 2;
            //Check if the Single element exist in the right of middle value
            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])) {
                start = mid + 2;
            } else if ((mid % 2 == 1 && nums[mid] == nums[mid - 1])) {
                start = mid + 1;
            } else {
                //Single element exist to the left of middle value
                end = mid;
            }
        }

        return nums[start];

    }

    public static void main(String args[]) {
        SingleElement singleElement = new SingleElement();
        int inputArray[] = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleElement.singleNonDuplicate(inputArray));

    }
}
