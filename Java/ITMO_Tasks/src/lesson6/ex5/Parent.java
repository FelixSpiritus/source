package lesson6.ex5;

import java.util.Scanner;

public class Parent {
    private int userAge;

    Scanner scanner = new Scanner(System.in);


    public void UserAsk() {
        System.out.print("Input user Age: ");
        this.userAge = scanner.nextInt();
        System.out.println("User Age: "+userAge);
    }
}
