package lesson4.part1;


public class ex5 {
    public static void main(String[] args) {
        boolean res = false;
        System.out.print("array = ");
        int[] arr = new int[] {3, -3, 7, 4, 5, 4, 3};
        for (int i = 0; i < arr.length ; i++){
            if (i == arr.length-1) {
                System.out.print(arr[i]);
            }
            else {
                System.out.print(arr[i]+",");
            }
        }
        if (arr[0]==3 || arr[arr.length-1]==3) {
            res = true;
        }
        System.out.println();
        System.out.println(res);
    }
}
