package com.leetcode.challenge.feb22;

/*
*
* https://leetcode.com/problems/remove-element/
* */
public class RemoveElementSol {

    public int removeElement(int[] nums, int val) {
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val) {
                nums[j]=nums[i];
                j++;
            }
        }
        return j;
    }


    public static void main(String[] args) {
        RemoveElementSol removeElementSol=new RemoveElementSol();
        int[] nums = {0,1,2,2,3,0,4,2};
        int val=2;
        System.out.println("Remaining element count :" + removeElementSol.removeElement(nums,val) );

    }

}
