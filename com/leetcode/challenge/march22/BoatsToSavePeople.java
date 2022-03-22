package com.leetcode.challenge.march22;

import java.util.Arrays;

/*
* Boats to save people
* https://leetcode.com/problems/boats-to-save-people/
* */
public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int numBoats = 0;
        int i = 0;
        int j = people.length - 1;

        while (i <= j) {
            if (people[i] + people[j] <= limit) {
                i++;
                j--;
            } else {
                j--;
            }
            numBoats++;
        }
        return numBoats;
    }

    public static void main(String[] args) {
        BoatsToSavePeople boatsToSavePeople = new BoatsToSavePeople();
        int people[] = {1, 2};
        int limit = 3;
        System.out.println("Result : " + boatsToSavePeople.numRescueBoats(people, limit));
    }
}
