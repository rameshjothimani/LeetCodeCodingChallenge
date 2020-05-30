package com.leetcode.challenge.may;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
 *  Day 30 - K Closest Points to Origin
 *
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 * Examples :
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 *  The distance between (1, 3) and the origin is sqrt(10).
 *  The distance between (-2, 2) and the origin is sqrt(8).
 *  Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 *  We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 *
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *
 * Note:
 *     1 <= K <= points.length <= 10000
 *     -10000 < points[i][0] < 10000
 *     -10000 < points[i][1] < 10000
 *
 * */


public class KClosestPointToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((a, b) -> {
            int distance_a = (int) (Math.pow(a[0], 2) + Math.pow(a[1], 2));
            int distance_b = (int) (Math.pow(b[0], 2) + Math.pow(b[1], 2));
            return distance_a - distance_b;
        });

        for (int i = 0; i < points.length; i++) {
            priorityQueue.offer(new int[]{points[i][0], points[i][1]});
        }

        int[][] result = new int[K][2];
        for (int i = 0; i < K; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;

    }

    public static void main(String args[]) {

        KClosestPointToOrigin obj = new KClosestPointToOrigin();
        int[][] points = {{1, 3}, {2, 2}};
        int K = 1;
        int[][] result = obj.kClosest(points, K);

        System.out.println(Arrays.deepToString(result));


    }
}
