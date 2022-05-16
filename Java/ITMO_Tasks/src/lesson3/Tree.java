package lesson3;

public class Tree {
    int age;
    boolean alive;
    String title;

    public Tree(int age, String title) {
        this.age = age;
        this.title = title;
    }

    public Tree(int age, boolean alive, String title) {
        this.age = age;
        this.alive = alive;
        this.title = title;
    }

    public Tree() {
        System.out.println("Пустой конструктор без параметров сработал");
    }

    public static void main(String[] args) {
        Tree tree1 = new Tree(150, "Oak");
        Tree tree2 = new Tree(50,true, "Birch");
        Tree tree3 = new Tree();
    }
}
