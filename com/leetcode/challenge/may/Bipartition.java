package com.leetcode.challenge.may;

/*
 * Day 27 - Possible Bipartition
 *
 * Given a set of N people (numbered 1, 2, ..., N), we would like to split everyone into two groups of any size.
 * Each person may dislike some other people, and they should not go into the same group.
 * Formally, if dislikes[i] = [a, b], it means it is not allowed to put the people numbered a and b into the same group.
 * Return true if and only if it is possible to split everyone into two groups in this way.
 *
 *
 * Examples :
 *
 * Input: N = 4, dislikes = [[1,2],[1,3],[2,4]]
 * Output: true
 * Explanation: group1 [1,4], group2 [2,3]
 *
 * Input: N = 3, dislikes = [[1,2],[1,3],[2,3]]
 * Output: false
 *
 * Input: N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * Output: false
 *
 * */


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartition {

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Queue<Integer> queueObj = new LinkedList<>();
        int[] visited = new int[N + 1];
        Arrays.fill(visited, -1);

        for (int i = 1; i < N + 1; i++) {
            if (visited[i] == -1) {
                visited[i] = 0;
                queueObj.offer(i);

                while (!queueObj.isEmpty()) {
                    int u = queueObj.poll();
                    for (int j = 0; j < dislikes.length; j++) {
                        if (dislikes[j][0] == u || dislikes[j][1] == u) {
                            int v = (dislikes[j][0] == u ? dislikes[j][1] : dislikes[j][0]);
                            if (visited[v] == -1) {
                                visited[v] = (visited[u] == 0 ? 1 : 0);
                                queueObj.offer(v);
                            } else if (visited[v] == visited[u]) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Bipartition bipartition = new Bipartition();
        int N = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        System.out.println(bipartition.possibleBipartition(N, dislikes));
    }
}
