package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class CorrelationBetweenArrays {

    public static void main(String[] args) {
        char[] array1 = new char[]{'a', 'b', 'c', 'x'};
        char[] array2 = new char[]{'z', 'y', 'i'};
//        == false

        char[] array3 = new char[]{'a', 'b', 'c', 'x'};
        char[] array4 = new char[]{'z', 'y', 'x'};
//        == true

        System.out.println(findCorrelationBetweenArraysBruteForce(array1, array2));
        System.out.println(findCorrelationBetweenArraysBruteForce(array3, array4));

        System.out.println(findCorrelationBetweenArraysImproved(array1, array2));
        System.out.println(findCorrelationBetweenArraysImproved(array3, array4));
    }

    // O(a*b)
    private static boolean findCorrelationBetweenArraysBruteForce(char[] array1, char[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return false;
        }

        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // O(a+b)
    private static boolean findCorrelationBetweenArraysImproved(char[] array1, char[] array2) {
        if (array1 == null || array2 == null || array1.length == 0 || array2.length == 0) {
            return false;
        }

        Set<Character> set = new HashSet<>(array1.length);
        for (char c : array1) {
            set.add(c);
        }
        // instead of the steps above, we can simply do: new HashSet<>(Arrays.asList(array1));

        for (char c : array2) {
            if (set.contains(c)) {
                return true;
            }
        }
        return false;
    }
}
