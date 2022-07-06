package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {
    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        int[] a = {0};
        ReentrantLock lock = new ReentrantLock();
        for (int i = 0; i < 1000; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        lock.lock();
                        a[0]++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(a[0]);
    }
}
