package thread;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run(){
                try {
                    System.out.println("thread1");
                    Thread.sleep(500);
                    System.out.println("thread1");
                } catch (Exception e) {
                    System.out.println("thread1 error");
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread2");
                    thread1.join();
                    System.out.println("thread2");
                } catch (Exception e) {
                    System.out.println("thread2 error");
                }
            }
        });
        thread2.start();
        thread1.start();
    }
}
