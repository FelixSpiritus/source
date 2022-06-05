package multithreading;

public class ThreadState extends Thread{
    @Override
    public void run() {
        System.out.println("During run: "+Thread.currentThread().getState());
        for (int i=0; i<101; i++){
            System.out.println(i);

        }
    }

    public static void main(String[] args){
        Thread thread = new ThreadState();
        System.out.println("Before run: "+thread.getState());
        thread.start();
        System.out.println("After run: "+thread.getState());
        try {
            thread.join();
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("After finished: "+thread.getState());
    }
}
