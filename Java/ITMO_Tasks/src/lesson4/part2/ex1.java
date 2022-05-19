package lesson4.part2;

public class ex1 {
    public static void main(String[] args) {
        boolean res = true;
        int[] arr = new int[]{2, 3, 7, 8, 9, 14, 3};
        for (int i = 0; i < arr.length-1; i++){
            if (arr[i] > arr[i+1]){
                res = false;
                break;
            }
        }
        if (res) {
            System.out.println("OK");
        }
        else{
            System.out.println("Please, try again");
        }
    }
}
