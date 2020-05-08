package com.leetcode.challenge.may;


/*
 * Day - 8
 * Check If It Is a Straight Line
 *
 * You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 * Example :
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 *
 *
 * Hint 1 :
 * If there're only 2 points, return true.
 *
 * Hint 2 :
 * Check if all other points lie on the line defined by the first 2 points.
 *
 * Hint 3:
 * Use cross product to check collinearity.
 *
 * */

public class StraightLineCheck {

    public boolean checkStraightLine(int[][] coordinates) {

        //According to the given condition
        if (coordinates.length == 2) {
            return true;
        }

        /*
         * 2D Array
         * [0][0]  [0][1]
         * [1][0]  [1][1]
         * [2][0]  [2][1]
         *
         * */
        for (int i = 1; i < coordinates.length - 2; i++) {
            int x1 = coordinates[i - 1][0];
            int y1 = coordinates[i - 1][1];

            int x2 = coordinates[i][0];
            int y2 = coordinates[i][1];

            int x3 = coordinates[i + 1][0];
            int y3 = coordinates[i + 1][1];

            //Slope Formula (y2-y1) / (x2-x1)
            //Check if slope1 & slope 2 are equal
            if ((y2 - y1) * (x3 - x2) != (y3 - y2) * (x2 - x1)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {
        StraightLineCheck straightLineCheck = new StraightLineCheck();
        //int input[][] = {{1, 2}, {0, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        //int input[][] = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}};
        int input[][] = {{-4, -3}, {1, 0}, {3, -1}, {0, -1}, {-5, 2}};
        System.out.println(straightLineCheck.checkStraightLine(input));
    }
}
