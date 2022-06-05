package multithreading;

public class ThreadName extends Thread{
    volatile String name = "zero";

    public synchronized void ShowName() {
        while(name.equals(Thread.currentThread().getName())){
            try {
                wait();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        name = Thread.currentThread().getName();
        System.out.println(name);
        notify();
    }

    @Override
    public void run() {
        while (true){
            ShowName();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        ThreadName threadName = new ThreadName();
        new Thread(threadName).start();
        new Thread(threadName).start();

    }
}
