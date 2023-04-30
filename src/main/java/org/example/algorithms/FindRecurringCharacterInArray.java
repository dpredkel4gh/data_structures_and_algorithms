package org.example.algorithms;

import java.util.HashSet;
import java.util.Set;

public class FindRecurringCharacterInArray {

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 5, 1, 2, 3, 5, 1, 2, 4}; // result 2
        int[] array2 = new int[]{2, 1, 1, 2, 3, 5, 1, 2, 4}; // result 1
        int[] array3 = new int[]{2, 3, 4, 5}; // no result

        System.out.println(findRecurringCharacter(array1));
        System.out.println(findRecurringCharacter(array2));
        System.out.println(findRecurringCharacter(array3));
    }

    // O(n)
    private static Integer findRecurringCharacter(int[] array) {
        if (array == null || array.length == 0 || array.length == 1) {
            return null;
        }

        Set<Integer> set = new HashSet<>(array.length);
        for (int val : array) {
            if (set.contains(val)) {
                return val;
            } else {
                set.add(val);
            }
        }
        return null;
    }
}
