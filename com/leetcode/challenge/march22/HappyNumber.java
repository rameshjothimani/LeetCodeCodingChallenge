package com.leetcode.challenge.march22;
/*
* Happy Number
* https://leetcode.com/problems/happy-number/
* */
public class HappyNumber {

    public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while (x > 1) {
            x = next(x);
            if (x == 1) return true;
            y = next((next(y)));
            if (y == 1) return true;

            if (x == y) return false;
        }

        return true;
    }

    private int next(int n) {
        int x = n;
        int sum = 0;
        while (x > 0) {
            sum = sum + (x % 10) * (x % 10);
            x = x / 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber happyNumber=new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
    }
}
