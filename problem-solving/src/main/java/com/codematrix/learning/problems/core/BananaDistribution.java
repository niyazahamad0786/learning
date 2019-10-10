package com.codematrix.learning.problems.core;

import java.util.Arrays;

public class BananaDistribution {

    public static void main(String[] args) {
        int[] nums = {10, 12, 15, 19, 20, 22, 25, 21, 27, 2, 39};
        Arrays.stream(nums).forEach(BananaDistribution::isEquallyDivisible);
    }

    private static void isEquallyDivisible(int n) {
        if (n <= 2) {
            System.out.println(n + ": No");
            return;
        }
        for (int i = 2; i <= Math.sqrt(n) + 1; i++) {
            if (n % i == 0) {
                System.out.println(n + ": Yes");
                return;
            }
        }
        System.out.println(n + ": No");
    }
}
