package org.example.algorithms.sort;

import java.util.Arrays;

public class SelectionSort {

    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int smallest = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            int temp = array[i];
            array[i] = array[smallest];
            array[smallest] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = {99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0};

        System.out.println(Arrays.toString(SelectionSort.selectionSort(numbers)));
    }
}
