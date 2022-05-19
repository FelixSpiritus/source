package lesson4.part1;

public class ex2 {
    public static void main(String[] args) {
        for (int i=1; i<101; i++){
            if (i % 3 == 0) {
                System.out.println(i+ " Делится на 3");
            }
            if (i % 5 == 0) {
                System.out.println(i+ " Делится на 5");
            }
            if (i % 5 == 0 && i % 3 == 0) {
                System.out.println(i+ " Делится на 3 и на 5");
            }
        }
    }
}
