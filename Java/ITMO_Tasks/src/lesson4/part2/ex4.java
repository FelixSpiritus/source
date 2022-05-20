package lesson4.part2;

public class ex4 {
    public static void findunic(int[] arr) {
        boolean unic;
        for (int i = 0; i < arr.length; i++){
            unic = true;
            for (int j = 0; j < arr.length; j++) {
                if (i!=j && arr[i]==arr[j]) {
                    unic = false;
                }
            }
            if (unic) {
                System.out.println("первое уникальное в этом массиве число: "+arr[i]);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1, 2, 4};
        findunic(arr);
    }
}
