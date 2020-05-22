package com.leetcode.challenge.may;
/*
*
* Day 21
* Count Square Submatrices with All Ones
*
* Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
*
* Input: matrix =
*[
*  [0,1,1,1],
*  [1,1,1,1],
*  [0,1,1,1]
*]
*Output: 15
*Explanation:
* There are 10 squares of side 1.
* There are 4 squares of side 2.
* There is  1 square of side 3.
* Total number of squares = 10 + 4 + 1 = 15.
*
*
* Input: matrix =
*[
*  [1,0,1],
*  [1,1,0],
*  [1,1,0]
*]
*Output: 7
*Explanation:
*There are 6 squares of side 1.
*There is 1 square of side 2.
*Total number of squares = 6 + 1 = 7.
*
*
* Constraints:
*  1 <= arr.length <= 300
*  1 <= arr[0].length <= 300
*  0 <= arr[i][j] <= 1
*
* */
public class CountSquareSubMatrices {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] tempMatrix = new int[m][n];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    tempMatrix[i][j] = matrix[i][j];
                } else {
                    tempMatrix[i][j] = matrix[i][j] == 1 ? Math.min(tempMatrix[i - 1][j], Math.min(tempMatrix[i - 1][j - 1], tempMatrix[i][j - 1])) + 1 : 0;
                }
                result += tempMatrix[i][j];
            }
        }

        return result;
    }

    public static void main(String args[]) {

        CountSquareSubMatrices countSquareSubMatrices = new CountSquareSubMatrices();
        int input[][] = {{0,1, 1, 1}, {1,1,1, 1}, {0,1, 1, 1}};
        System.out.println("Number of Square Sub-matrices : "+countSquareSubMatrices.countSquares(input));

    }
}
