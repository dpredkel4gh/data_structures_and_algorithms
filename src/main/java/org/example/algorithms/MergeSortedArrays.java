package org.example.algorithms;

import java.util.Arrays;

public class MergeSortedArrays {

    public static void main(String[] a) {
        int[] result = merge(new int[]{0, 2, 3}, new int[]{1, 4});
        String s = Arrays.toString(result);
        System.out.println(s);
    }

    // O(n+m) time
    // O(n+m) space
    public static int[] merge(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int numberOfItems = length1 + length2;

        int array1Index = 0;
        int array2Index = 0;

        int[] result = new int[numberOfItems];

        for (int i = 0; i < numberOfItems; i++) {
            int array1Val = array1Index == length1 ? Integer.MAX_VALUE : array1[array1Index];
            int array2Val = array2Index == length2 ? Integer.MAX_VALUE : array2[array2Index];
            if (array1Val <= array2Val) {
                result[i] = array1Val;
                array1Index++;
            } else {
                result[i] = array2Val;
                array2Index++;
            }
        }
        return result;
    }
}
