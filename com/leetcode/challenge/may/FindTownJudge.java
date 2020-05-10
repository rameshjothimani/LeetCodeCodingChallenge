package com.leetcode.challenge.may;

/*
 *
 * Day - 10
 *
 * Find the town Judge
 *
 * In a town, there are N people labelled from 1 to N.
 * There is a rumor that one of these people is secretly the town judge.
 * If the town judge exists, then:
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 * You are given trust, an array of pairs trust[i] = [a, b] representing that the person labelled a trusts the person labelled b.
 * If the town judge exists and can be identified, return the label of the town judge.  Otherwise, return -1.
 *
 *Example :
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 * Note:
 *   1 <= N <= 1000
 *   trust.length <= 10000
 *   trust[i] are all different
 *   trust[i][0] != trust[i][1]
 *   1 <= trust[i][0], trust[i][1] <= N
 *
 * */

public class FindTownJudge {

    public int findJudge(int N, int[][] trust) {

        //To be a judge, there must be N-1 people who should trust
        if (trust.length < N - 1) {
            return -1;
        }

        int[] othersTrustYou = new int[N + 1];
        int[] youTrustOthers = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            youTrustOthers[trust[i][0]]++;
            othersTrustYou[trust[i][1]]++;
        }

        for (int j = 1; j <= N; j++) {
            //If all others trust you & you trust no one, then you're the judge
            if (othersTrustYou[j] == N - 1 && youTrustOthers[j] == 0) {
                return j;
            }
        }

        return -1;
    }

    public static void main(String args[]) {

        FindTownJudge findTownJudge = new FindTownJudge();
        int input[][] = {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}};
        System.out.println("Town Judge : " + findTownJudge.findJudge(4, input));
    }
}
