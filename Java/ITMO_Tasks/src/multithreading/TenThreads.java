package multithreading;

public class TenThreads extends Thread{
    @Override
    public void run() {
        for (int i=0; i<101; i++){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        TenThreads tenThreads = new TenThreads();
        for (int i = 0; i < 10; i++) {
            new Thread(tenThreads).start();
        }
    }
}
