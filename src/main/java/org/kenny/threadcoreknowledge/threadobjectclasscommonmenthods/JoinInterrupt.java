package org.kenny.threadcoreknowledge.threadobjectclasscommonmenthods;

import java.util.concurrent.TimeUnit;

/**
 * Demonstrate the effect of being interrupted during a join
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    mainThread.interrupt();
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName() + " finished");
                } catch (InterruptedException e) {
                    System.out.println("Thread 1 was interrupted");
                }
            }
        }, "Thread 1");
        thread1.start();
        System.out.println("Waiting for the thread 1 finishing the task");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " : main thread was interrupted");

            thread1.interrupt();
        }
        System.out.println("Thread 1 was finished");
        // Main thread run this, so, it will be printed out
        // due to thread 1 need to sleep 5 seconds,
        // so, the main thread will, finish this print firstly
    }
}
