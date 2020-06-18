package com.mare.fleet.binarytree;

/*
* https://leetcode.com/problems/same-tree/
* 100. Same Tree
 Given two binary trees, write a function to check if they are the same or not.

Two binary trees are considered the same if they are structurally identical and the nodes have the same value.

Example 1:

Input:     1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

Output: true
Example 2:

Input:     1         1
          /           \
         2             2

        [1,2],     [1,null,2]

Output: false
Example 3:

Input:     1         1
          / \       / \
         2   1     1   2

        [1,2,1],   [1,1,2]

Output: false
*
* */

public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        else if ((p == null && q != null) || (q == null && p != null))
            return false;
        else if (p.val != q.val)
            return false;
        else
            return (isSameTree(p.left, q.left) && (isSameTree(p.right, q.right)));

    }


    public static void main(String[] args) {
        TreeNode rootNode1 = new TreeNode(1);
        rootNode1.left = new TreeNode(2);
        rootNode1.right = new TreeNode(3);


        TreeNode rootNode2 = new TreeNode(1);
        rootNode2.left = new TreeNode(2);
        rootNode2.right = new TreeNode(3);

        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(rootNode1, rootNode2));
    }
}
