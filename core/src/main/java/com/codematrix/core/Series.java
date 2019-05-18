package com.codematrix.core;

import static java.lang.Math.*;

public class Series {

    // (a + k^0 * b), (a + k^0 * b + k^1 * b), (a + k^0 * b + k^1 * b + k ^ 2 * b), ..., (a + k^0 * b + k^1 * b + ... + k^n-1 * b)

    public static void main(String[] args) {
        printSeries(5, 3, 5, 2);
    }

    private static void printSeries(int a, int b, int n, int k) {
        int term = 0;
        for (int i = 0 ; i < n; i++) {
            for (int j = 0; j <= i ; j++) {
                term += b * Math.pow(2, j);
            }
            System.out.print((a + term) + " ");
            term = 0;
        }
    }
}
