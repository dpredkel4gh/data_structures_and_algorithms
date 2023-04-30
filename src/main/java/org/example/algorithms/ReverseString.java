package org.example.algorithms;

public class ReverseString {

    public static void main(String[] a) {
        String result = reverse1("123hel!");
        System.out.println(result);

        result = reverse2("123hel!");
        System.out.println(result);

        result = reverseWithJava("123hel!");
        System.out.println(result);

        result = reversalRecursive("123hel!");
        System.out.println(result);
    }

    public static String reverse1(String string) {
        char[] charArray = string.toCharArray();
        char[] resultArray = new char[charArray.length];

        for (int i = charArray.length - 1, j = 0; i >= 0; i--, j++) {
            resultArray[j] = charArray[i];
        }
        return new String(resultArray);
    }

    public static String reverse2(String string) {
        char[] charArray = string.toCharArray();
        int tempIndex;
        char tempVal;
        for (int i = 0; i < Math.floor((double) charArray.length / 2); i++) {
            tempIndex = charArray.length - 1 - i;
            tempVal = charArray[tempIndex];
            charArray[tempIndex] = charArray[i];
            charArray[i] = tempVal;
        }
        return new String(charArray);
    }


    public static String reverseWithJava(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static String reversalRecursive(String str) {
        if (str.isEmpty()) {
            return "";
        }
        return reversalRecursive(str.substring(1)) + str.charAt(0);
    }
}
