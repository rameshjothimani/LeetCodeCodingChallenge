package com.leetcode.challenge.may;

//Day 7

/*
* Cousins in Binary Tree
*In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
*Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
*We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
*Return true if and only if the nodes corresponding to the values x and y are cousins.
*
*Input: root = [1,2,3,4], x = 4, y = 3
*Output: false
*
* Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
* Output: true
*
* Input: root = [1,2,3,null,4], x = 2, y = 3
* Output: false
*
*
* */

public class BinaryTreeCousins {
    TreeNode parent;
    int level;

    BinaryTreeCousins(TreeNode parent, int level) {
        this.parent = parent;
        this.level = level;
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        BinaryTreeCousins leftSideOfRoot = findNodeLocation(root, x, null, 0);
        BinaryTreeCousins rightSideOfRoot = findNodeLocation(root, y, null, 0);

        if (leftSideOfRoot.level == rightSideOfRoot.level && leftSideOfRoot.parent != rightSideOfRoot.parent) {
            return true;
        }

        return false;
    }

    BinaryTreeCousins findNodeLocation(TreeNode root, int val, TreeNode parent, int level) {

        //Check if root exists
        if (root == null) {
            return null;
        } else if (root.val == val) { //Check if the root value & the value to be compared is the same
            return new BinaryTreeCousins(parent, level);
        } else { //Recursively check the nodes
            BinaryTreeCousins leftBinaryTreeCousins = findNodeLocation(root.left, val, root, level + 1);
            BinaryTreeCousins rightBinaryTreeCousins = findNodeLocation(root.right, val, root, level + 1);
            if (leftBinaryTreeCousins != null) {
                return leftBinaryTreeCousins;
            } else {
                return rightBinaryTreeCousins;
            }

        }
    }

    public static void main(String args[]) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.right = new TreeNode(3);
        root.right.right = new TreeNode(5);

        BinaryTreeCousins binaryTreeCousins = new BinaryTreeCousins(root, 1);
        System.out.println(binaryTreeCousins.isCousins(root, 4, 5));
    }
}