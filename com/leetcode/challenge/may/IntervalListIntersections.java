package com.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Day 23 - Interval List Intersections
 *
 * Given two lists of closed intervals, each list of intervals is pairwise disjoint and in sorted order.
 * Return the intersection of these two interval lists.
 * (Formally, a closed interval [a, b] (with a <= b) denotes the set of real numbers x with a <= x <= b.
 * The intersection of two closed intervals is a set of real numbers that is either empty, or can be represented as a closed interval.
 *
 * For example, the intersection of [1, 3] and [2, 4] is [2, 3].)
 *
 *
 * Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
 * Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
 * Reminder: The inputs and the desired output are lists of Interval objects, and not arrays or lists.
 *
 *Note:
 *  0 <= A.length < 1000
 *  0 <= B.length < 1000
 *  0 <= A[i].start, A[i].end, B[i].start, B[i].end < 10^9
 *  NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 **
 * */


public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> intersectList = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < A.length && j < B.length) {
            //if Min(end1 & end2) >= Max(start1 & start2) then the intersection exists

            int minEnd = Math.min(A[i][1], B[j][1]);
            int maxStart = Math.max(A[i][0], B[j][0]);

            if (minEnd >= maxStart) {
                intersectList.add(new int[]{maxStart, minEnd});
            }

            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] result = new int[intersectList.size()][2];
        i = 0;

        for (int[] intersectArray : intersectList) {
            result[i++] = intersectArray;
        }

        return result;
    }

    public static void main(String args[]) {
        IntervalListIntersections intervalListIntersections = new IntervalListIntersections();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};

        int[][] output = intervalListIntersections.intervalIntersection(A, B);
        System.out.println("Intersection Range : " + Arrays.deepToString(output));
    }

}
