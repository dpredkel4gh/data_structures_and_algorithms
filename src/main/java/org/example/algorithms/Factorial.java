package org.example.algorithms;

public class Factorial {

    public static void main(String[] a) {
        int result = calculateFactorial(5);
        System.out.println(result);
    }

    // O(n)
    public static int calculateFactorial(int val) {
        if (val == 1) {
            return val;
        }
        return val * calculateFactorial(val - 1);
    }
}
