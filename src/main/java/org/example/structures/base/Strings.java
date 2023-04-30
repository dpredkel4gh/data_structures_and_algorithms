package org.example.structures.base;

public class Strings {

    public static void main(String[] args) {
        split();
    }

    public static void split(){
        String str = "hello,world";

        String[] result = str.split(",");

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
