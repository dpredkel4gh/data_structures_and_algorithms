package org.example.algorithms;

import java.util.HashSet;

public class FirstRecurringElement {

    //[2,5,1,2,3,5,1,2,4] -> 2
    //[2,1,1,2,3,5,1,2,4] -> 1
    //[2,3,4,5] -> null
    //[2,5,5,2,3,5,1,2,4] -> 5
    private static Integer firstRecurringCharacter(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int element : array) {
            if (hashSet.contains(element)) {
                return element;
            } else {
                hashSet.add(element);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 5, 2, 3, 5, 1, 2, 4};
        System.out.println(firstRecurringCharacter(arr));
    }
}
