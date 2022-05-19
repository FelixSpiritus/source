package lesson4.part1;

public class ex6 {
    public static void main(String[] args) {
        boolean res = false;
        int[] arr = new int[]{2, -3, 7, 1, 4, 4, 3};
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 3) {
                res = true;
                break;
            }
        }
        System.out.println("содержит 1 или 3: " + res);
    }
}
