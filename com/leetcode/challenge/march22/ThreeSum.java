package com.leetcode.challenge.march22;
/*
 * Three Sum
 * https://leetcode.com/problems/3sum/
 * */

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) return new ArrayList<>();

        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1;
            int k = n - 1;
            while ( j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    resultSet.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                }else if(sum>0) k--;
                else j++;
            }
        }

        return new ArrayList<>(resultSet);

        /*Arrays.sort(nums);
        List<List<Integer>> resultList = new LinkedList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        resultList.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > sum) {
                        high--;
                    } else {
                        low++;
                    }
                }

            }

        }
        return resultList;*/
    }


    public static void main(String[] args) {
        ThreeSum object = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> resultList= object.threeSum(nums);
       for(List<Integer> result: resultList){
           result.forEach(System.out::println);
       }
    }
}
