package multithreading;

public class Temp {
    volatile String name = "zero";

    public synchronized void ShowName() {
        //System.out.println("up "+Thread.currentThread().getId());
        //System.out.println("up "+Thread.currentThread().getName());
        try {
            while(name.equals(Thread.currentThread().getName())){
                wait();
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        name = Thread.currentThread().getName();
        System.out.println(name);
        notify();
    }



    public static void main(String[] args) {
        Temp temp = new Temp();
        ThreadOne t1 = new ThreadOne(temp);
        new Thread(t1).start();
        new Thread(t1).start();
    }
}
class ThreadOne implements Runnable{
    Temp temp;

    public ThreadOne(Temp temp) {
        this.temp=temp;
    }

    @Override
    public void run() {
        while (true) {
            temp.ShowName();
        }
    }
}
