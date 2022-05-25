package lesson7;

public class Main {
    public static void main(String[] args) {
        Plane plane =new Plane();
        Plane.Wing wing1 = plane.new Wing();
        Plane.Wing wing2 = plane.new Wing();
        wing1.setWeight(250);
        wing2.setWeight(300);
        System.out.println("Wing1 weight is: "+wing1.getWeight());
        System.out.println("Wing2 weight is: "+wing2.getWeight());
    }
}
