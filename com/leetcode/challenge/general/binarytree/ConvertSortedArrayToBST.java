package com.leetcode.challenge.general.binarytree;

/*
* https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* 108. Convert Sorted Array to Binary Search Tree
*
* Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
*
* */
public class ConvertSortedArrayToBST {

    public static void main(String[] args) {
        ConvertSortedArrayToBST obj = new ConvertSortedArrayToBST();
        int[] nums = {-10, -3, 0, 5, 9};
        obj.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return constructBSTRecursive(nums, 0, nums.length - 1);

    }

    private TreeNode constructBSTRecursive(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;

        TreeNode rootNode = new TreeNode(nums[mid]);
        rootNode.left = constructBSTRecursive(nums, left, mid - 1);
        rootNode.right = constructBSTRecursive(nums, mid + 1, right);

        return rootNode;

    }
}
