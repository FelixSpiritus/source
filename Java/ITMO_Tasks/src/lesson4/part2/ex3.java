package lesson4.part2;

import java.util.Arrays;

public class ex3 {
    public static void arrChange(int[] arr) {
        if (arr.length > 1) {
            int a = arr[0];
            int b = arr[arr.length-1];
            arr[0] = b;
            arr[arr.length-1] = a;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 7, 8, 9, 14, 3};
        System.out.println("Array 1: "+ Arrays.toString(arr));
        arrChange(arr);
        System.out.println("Array 2: "+ Arrays.toString(arr));
    }
}
