package lesson4.part2;

import java.util.Arrays;
import java.util.Scanner;

public class ex2 {

    public static int[] setArray() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Array length: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Numbers of array:");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println("Result: "+Arrays.toString(setArray()));

    }

}
