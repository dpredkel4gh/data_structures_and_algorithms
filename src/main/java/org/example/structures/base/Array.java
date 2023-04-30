package org.example.structures.base;

public class Array {

    public static void main(String[] args) {
        arrays();
    }

    public static void arrays() {
        String[] array1d = new String[]{"1", "2", "3"};
        String[] array1dSize = new String[3];

        // x[row_index][column_index]
        int[][] array2d = {
                {1, 2, 3, 4},
                {5, 6, 7}
        };
        int[][] array2dSize = new int[5][6];
        //2
        System.out.println(array2d.length);

        // x[array_index][row_index][column_index]
        int[][][] array3d = {
                {
                        {1, 2, 3, 4},
                        {5, 6, 7}
                },
                {
                        {5, 6, 7}
                }
        };
        int[][][] array3dSize = new int[2][3][3];
        //2
        System.out.println(array3dSize.length);
    }
}
