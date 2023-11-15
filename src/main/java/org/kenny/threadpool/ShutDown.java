package org.kenny.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Demonstration of shutdown the thread pool
 */
public class ShutDown {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
            executorService.execute(new ShutDownTask());
        }
        TimeUnit.MILLISECONDS.sleep(1500);
        System.out.println("isShutdown: " + executorService.isShutdown());
        executorService.shutdown();
        System.out.println("isShutdown: " + executorService.isShutdown());
        System.out.println("isTerminated: " + executorService.isTerminated());
        executorService.execute(new ShutDownTask());
        TimeUnit.MILLISECONDS.sleep(5000);
        System.out.println("After 10 seconds, isTerminated: " + executorService.isTerminated());

    }
}

class ShutDownTask implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
