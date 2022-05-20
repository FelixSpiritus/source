package lesson4.part1;

public class ex6 {
    public static boolean check1or3(int[] arr){
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1 || arr[i] == 3) {
                res = true;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{2, -3, 7, 1, 4, 4, 3};
        System.out.println("содержит 1 или 3: " + check1or3(arr));
    }
}
