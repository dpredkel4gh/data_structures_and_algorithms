package org.example.structures.base;

public class Math {
    public static void main(String[] args) {
        math();
    }

    public static void math() {
        int minValue = Integer.MIN_VALUE;
        System.out.println(minValue);

        // it becomes Integer.MAX_VALUE;
        int newMinVal = minValue - 1;
        System.out.println(newMinVal);

        int maxValue = Integer.MAX_VALUE;
        System.out.println(maxValue);

        // it becomes Integer.MIN_VALUE;
        int newMaxValue = maxValue + 1;
        System.out.println(newMaxValue);
    }
}
