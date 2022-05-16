package lesson2;

public class Traning {
    private String trainer;
    private String title;
    private int duration;
    private int memberqty;
    private int price;

    public Traning(){

    }

    public Traning(String trainer, String title, int duration, int memberqty, int price) {
        this.trainer = trainer;
        this.title = title;
        this.duration = duration;
        this.memberqty = memberqty;
        this.price = price;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) {
        Traning tran = new Traning();
        tran.setTrainer("Ivanov");
        tran.setTitle("Tradings");
        tran.setPrice(100);
    }
}
