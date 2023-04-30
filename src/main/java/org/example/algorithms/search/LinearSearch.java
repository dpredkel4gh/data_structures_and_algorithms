package org.example.algorithms.search;

public class LinearSearch {
    public static int linearSearch(int[] arr, int key) {
        // if a key is found return its index, else return -1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {12, 45, 69, 78, 89, 54};

        int answer = LinearSearch.linearSearch(arr, 69);
        System.out.println(answer);
    }
}
