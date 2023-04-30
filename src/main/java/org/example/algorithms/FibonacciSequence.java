package org.example.algorithms;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class FibonacciSequence {

    //  0+1=1; 1+1=2; 2+3=5; 3+5=8; 5+8=13; ...
    // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...]
    public static void main(String[] a) {
        long start = now();
        int result = fibonacci(50);
        long end = now();
        System.out.println(result + " " + (end - start));

        start = now();
        result = fibonacciRec2(50);
        end = now();
        System.out.println(result + " " + (end - start));

        start = now();
        result = fibonacciCached(50);
        end = now();
        System.out.println(result + " " + (end - start));
    }

    public static int fibonacci(int index) {
        if (index == 0 || index == 1) {
            return index;
        }
        return fibonacciRec(2, index, 0, 1);
    }

    // O(n)
    private static int fibonacciRec(int currentIndex, int index, int val1, int val2) {
        if (currentIndex == index) {
            return val1 + val2;
        }
        return fibonacciRec(currentIndex + 1, index, val2, val1 + val2);
    }

    // O(2^n)
    // can be improved using caches, see below
    public static int fibonacciRec2(int index) {
        if (index < 2) {
            return index;
        }
        return fibonacciRec2(index - 1) + fibonacciRec2(index - 2);
    }

    private static final Map<Integer, Integer> cache = new HashMap<>();

    public static int fibonacciCached(int index){
        if (cache.containsKey(index)) {
            return cache.get(index);
        } else {
            if (index < 2) {
                return index;
            } else {
                cache.put(index, fibonacciCached(index - 1) + fibonacciCached(index - 2));
                return cache.get(index);
            }
        }
    }

    public static int fibonacciIteratively(int index) { //O(n)
        if(index == 0) {
            return index;
        }
        int result = 1;
        int lastNumber = 0;
        int temp;
        for (int i = 1; i < index; i++) {
            temp = result;
            result += lastNumber;
            lastNumber = temp;
        }
        return result;
    }

    private static long now() {
        return Instant.now().toEpochMilli();
    }
}
