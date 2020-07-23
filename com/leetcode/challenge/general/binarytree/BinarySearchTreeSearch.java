package com.leetcode.challenge.general.binarytree;

/*
https://leetcode.com/problems/search-in-a-binary-search-tree/
* 700. Search in a Binary Search Tree

Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
*
* */
public class BinarySearchTreeSearch {

    public static void main(String[] args) {

        TreeNode rootNode = new TreeNode(4);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(7);
        rootNode.left.left = new TreeNode(1);
        rootNode.left.right = new TreeNode(3);

        BinarySearchTreeSearch obj = new BinarySearchTreeSearch();
        obj.searchBST(rootNode, 2);

    }

    public TreeNode searchBST(TreeNode root, int val) {

        if (root == null) return null;
        if (root.val == val) return root;
        if (root.val < val) return searchBST(root.right, val);

        return searchBST(root.left, val);
    }
}
