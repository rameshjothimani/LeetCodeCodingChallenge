package com.leetcode.challenge.may;

/*
 *
 * Day 25 - Uncrossed Lines
 *
 * We write the integers of A and B (in the order they are given) on two separate horizontal lines.
 * Now, we may draw connecting lines: a straight line connecting two numbers A[i] and B[j] such that:
 * A[i] == B[j];
 *
 * The line we draw does not intersect any other connecting (non-horizontal) line.
 * Note that a connecting lines cannot intersect even at the endpoints: each number can only belong to one connecting line.
 * Return the maximum number of connecting lines we can draw in this way.
 *
 * Examples :
 * Input: A = [1,4,2], B = [1,2,4]
 * Output: 2
 * Explanation: We can draw 2 uncrossed lines as in the diagram.
 * We cannot draw 3 uncrossed lines, because the line from A[1]=4 to B[2]=4 will intersect the line from A[2]=2 to B[1]=2.
 *
 *
 * Input: A = [2,5,1,2,5], B = [10,5,2,1,5,2]
 * Output: 3
 *
 * Input: A = [1,3,7,1,7,5], B = [1,9,2,5,1]
 * Output: 2
 * */

public class UnCrossedLines {

    public int maxUncrossedLines(int[] A, int[] B) {
        if(A.length==0||B.length==0){
            return 0;
        }

        int[][] dp = new int[A.length + 1][B.length + 1];

        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                dp[i][j] = (A[i] == B[j] ? dp[i + 1][j + 1] + 1 : Math.max(dp[i][j + 1], dp[i + 1][j]));
            }
        }

        return dp[0][0];
    }

    public static void main(String args[]) {
        UnCrossedLines unCrossedLines = new UnCrossedLines();
        int[] A = {1, 4, 2};
        int[] B = {1, 2, 4};
        System.out.println(unCrossedLines.maxUncrossedLines(A, B));
    }
}
