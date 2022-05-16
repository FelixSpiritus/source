package lesson3;

public class Car {
    String color;
    String title;
    int weight;

    public Car(String color, String title, int weight) {
        this.color = color;
        this.title = title;
        this.weight = weight;

    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", title='" + title + '\'' +
                ", weight=" + weight +
                '}';
    }

    public Car(String color) {
        this.color = color;
    }

    public Car(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public Car() {
    }

    public static void main(String[] args) {
        Car car1= new Car("red", "ford", 1500);
        Car car2= new Car("blue", "nissan", 1700);
        System.out.println(car1);
        System.out.println(car2);
    }



}
