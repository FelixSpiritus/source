package lesson4.part1;

import java.util.Scanner;

public class ex3 {
    public static void main(String[] args) {
        boolean res = false;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int b = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int c = scanner.nextInt();
        if (a + b == c) {
            res = true;
        }
        System.out.println("Результат: " + res);
    }
}
