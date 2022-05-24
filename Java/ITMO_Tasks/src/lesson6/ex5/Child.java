package lesson6.ex5;

public class Child extends Parent {
    String userName;

    public Child() {
    }

    @Override
    public void UserAsk() {
        System.out.print("Input user Name: ");
        this.userName = scanner.next();
        System.out.println("User Name: "+ userName);
    }
}
