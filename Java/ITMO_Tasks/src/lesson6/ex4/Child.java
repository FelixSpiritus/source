package lesson6.ex4;

public class Child extends Parent{

    public Child() {
    }

    public void printParentNum() {
        System.out.println("Num from parent class: "+super.num);
    }
}
