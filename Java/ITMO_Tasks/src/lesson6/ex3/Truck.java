package lesson6.ex3;

public class Truck extends Car {
    private int wheelsQty;
    private int maxWeight;

    public void setWheelsQty(int wheelsQty) {
        this.wheelsQty = wheelsQty;
        System.out.println("New wheels quantity: "+wheelsQty);
    }

    public Truck(int w, String m, char c, float s, int wheelsQty, int maxWeight) {
        super(w, m, c, s);
        this.wheelsQty = wheelsQty;
        this.maxWeight = maxWeight;
    }
}
