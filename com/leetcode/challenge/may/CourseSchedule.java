package com.leetcode.challenge.may;

import java.util.ArrayList;
import java.util.List;

/*
*
* Day 29 - Course Schedule
*
* There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
*
* Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
*
* Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
*
*
* Examples :
* Input: numCourses = 2, prerequisites = [[1,0]]
* Output: true
* Explanation: There are a total of 2 courses to take.
*              To take course 1 you should have finished course 0. So it is possible.
*
* Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
* Output: false
* Explanation: There are a total of 2 courses to take.
*             To take course 1 you should have finished course 0, and to take course 0 you should
*             also have finished course 1. So it is impossible.
*
* Constraints:
*
* The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
* You may assume that there are no duplicate edges in the input prerequisites.
* 1 <= numCourses <= 10^5
*
* */

public class CourseSchedule {

    List<Integer>[] adjElements;
    boolean[] isVisited;
    boolean[] isExplored;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        adjElements = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adjElements[i] = new ArrayList<>();
        }

        isVisited = new boolean[numCourses];
        isExplored = new boolean[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            adjElements[prerequisites[i][0]].add(prerequisites[i][1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!isVisited[i]) {
                if (isCyclic(i)) {
                    return false;
                }

            }
        }

        return true;

    }

    boolean isCyclic(int i) {
        isVisited[i] = true;
        for (Integer v : adjElements[i]) {
            if (!isVisited[v]) {
                if (isCyclic(v)) {
                    return true;
                }
            } else if (!isExplored[v]) {
                return true;
            }
        }

        isExplored[i] = true;
        return false;
    }

    public static void main(String args[]) {
        CourseSchedule courseSchedule = new CourseSchedule();
        int[][] prerequisites = {{1, 0}, {0, 1}};
        int numCourses = 2;
        System.out.println(courseSchedule.canFinish(numCourses, prerequisites));
    }
}
