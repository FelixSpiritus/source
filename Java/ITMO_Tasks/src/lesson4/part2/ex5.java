package lesson4.part2;

import java.util.Arrays;
import java.util.Random;

public class ex5 {
    public static int[] mergeSort(int[] arr) {
        //System.out.println(Arrays.toString(arr));
        if (arr.length < 2) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = new int[mid];
        int[] right;

        if (arr.length % 2 == 0) {
            right = new int[mid];
        } else {
            right = new int[mid + 1];
        }

        for (int i = 0; i < mid; i++) {
            left[i] = arr[i];
        }

        for (int j = 0; j < right.length; j++) {
            right[j] = arr[mid + j];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeParts(left, right);
    }
    private static int[] mergeParts(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int leftPointer = 0;
        int rightPointer = 0;
        int resultPointer = 0;

        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            } else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            } else {
                result[resultPointer++] = right[rightPointer++];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[11];
        for ( int i = 0; i < arr.length; i++){
            arr[i] = random.nextInt(99);
        }
        System.out.println("Array 1: "+ Arrays.toString(arr));
        System.out.println("Array 2: "+ Arrays.toString(mergeSort(arr)));
    }
}
