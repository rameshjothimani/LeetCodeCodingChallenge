package com.leetcode.challenge.general.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
* https://leetcode.com/problems/binary-tree-level-order-traversal/
* 102. Binary Tree Level Order Traversal
*
* Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
* */


public class LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                root = queue.poll();
                list.add(root.val);
                if (root.left != null) {
                    queue.offer(root.left);
                }

                if (root.right != null) {
                    queue.offer(root.right);
                }
            }
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String[] args) {
        LevelOrderTraversal obj = new LevelOrderTraversal();

        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);
        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);

        List<List<Integer>> resultLists = obj.levelOrder(rootNode);

        for (List<Integer> resultList : resultLists) {
            System.out.println("Level:");
            for (int i = 0; i < resultList.size(); i++) {
                System.out.println(resultList.get(i));
            }
        }

    }
}
