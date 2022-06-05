package multithreading;

import java.util.ArrayList;
import java.util.List;

public class Counter implements Runnable {
    private volatile int count = 0;

    public synchronized void increment() {
        count = count + 1;
    }
    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (int i=0; i<1000; i++){
            increment();
            System.out.println(Thread.currentThread().getName()+": "+count);
        }
    }
    public static void main(String[] args){
        Counter counter = new Counter();
        List<Thread> tList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(counter);
            tList.add(thread);
            thread.start();
        }
        try {
            for (Thread t : tList) {
                t.join();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.getCount());
    }
}
